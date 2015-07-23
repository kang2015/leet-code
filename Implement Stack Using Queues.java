class MyStack {
    Queue<Integer> que = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        que.offer(x);
        int i = que.size()-1;
        while(i>0){
            que.offer(que.poll());
            i--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        que.poll();
    }

    // Get the top element.
    public int top() {
        return que.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.size() == 0;
    }
}
