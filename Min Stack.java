//two stack, one for data, one for current min
class MinStack {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> minr = new Stack<Integer>();
    public void push(int x) {
        data.push(x);
        if(minr.empty()||x<minr.peek()){
            minr.push(x);
        }else{
            minr.push(minr.peek());
        }
    }

    public void pop() {
        data.pop();
        minr.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minr.peek();
    }
}


//minor space optimization
class MinStack {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> minr = new Stack<Integer>();
    public void push(int x) {
        data.push(x);
        if(minr.empty()||x<=minr.peek()){
            minr.push(x);
        }
    }

    public void pop() {
        int cur = data.pop();
        if(cur == minr.peek())
            minr.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minr.peek();
    }
}

//one stack
class MinStack {
    private Stack<Long> data = new Stack<Long>();
    private Long min;
    public void push(int x) {
        if(data.empty()){
            data.push(0L);
            min = new Long(x);
        }else{
            data.push(new Long(x-min));//cur = x- min
            if(x<min) min= new Long(x);//newMin = data; cur = data- lastMin;
        }
        
    }

    public void pop() {
       if(data.empty()){
           return;
       }
       Long cur = data.pop();
       if(cur < 0){
           min = min-cur;//lastMin = data - cur = newMin - cur;
       }
    }

    public int top() {
        Long cur = data.peek();
        if(cur < 0){
            return min.intValue();// newMin = data;
        }else{
            cur = cur+ min;
            return cur.intValue();
        }
    }

    public int getMin() {
        return min.intValue();
    }
}
