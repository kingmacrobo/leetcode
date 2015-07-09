// Stack solution
// Time is O(n), space is O(n).

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = tokens.length,a;
        if (n == 0) return 0;
        for (int i = 0; i < n; ++i) {
            char op = tokens[i].charAt(0);
            if (tokens[i].length() == 1 && (op > '9' || op < '0')) {
                switch (op) {
                    case '+':
                        stack.push(stack.pop()+stack.pop());
                        break;
                    case '-':
                        a = stack.pop();
                        stack.push(stack.pop() - a);
                        break;
                    case '*':
                        stack.push(stack.pop()*stack.pop());
                        break;
                    case '/':
                        a = stack.pop();
                        stack.push(stack.pop()/a);
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
