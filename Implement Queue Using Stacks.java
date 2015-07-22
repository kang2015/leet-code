class MyQueue {
    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!outStack.empty()){
            outStack.pop();
        }else{
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            outStack.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!outStack.empty()){
            return outStack.peek();
        }else{
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
