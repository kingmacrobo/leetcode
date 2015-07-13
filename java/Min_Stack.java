// Using a extra stack to record the mininums status.
// Just like state machine!
// Time is O(1) in each operation, space is O(n).
// We can also reduce the space by just record the minimus status when a new min appears.

class MinStack {
    Stack<Integer> values = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    public void push(int x) {
        values.push(x);
        if (mins.empty() || x < mins.peek()) {
            mins.push(x);
        }
        else {
            mins.push(mins.peek());
        }
    }

    public void pop() {
        values.pop();
        mins.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
