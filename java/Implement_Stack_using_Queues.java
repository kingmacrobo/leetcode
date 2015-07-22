// Using one queue to implement stack.
// The main operation is move the front n-1 value to the back, which makes the last value on the head of the queue.
// Time is O(n) on pop and top, but O(1) on push, space is O(n).

class MyStack {
    // Push element x onto stack.
    Queue<Integer> que = new LinkedList<Integer>();
    public void push(int x) {
        que.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = que.size();
        for (int i = 0; i < size-1; ++i)
            que.offer(que.poll());
        que.poll();
    }

    // Get the top element.
    public int top() {
        int size = que.size();
        for (int i = 0; i < size-1; ++i)
            que.offer(que.poll());
        int val = que.peek();
        que.offer(que.poll());
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.peek() == null;
    }
}
