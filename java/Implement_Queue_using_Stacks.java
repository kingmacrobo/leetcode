// Using two stacks to implement a queue.
// The time of push is O(n), pop() and peek() is O(1), space is O(n).

class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack2.empty();
    }
}
