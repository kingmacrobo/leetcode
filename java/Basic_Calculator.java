// Stack method!
// Using a stack to store the previous values and oprators.
// We can calculate the expression among the deepest parentheses firstly via stack method.
// And then iteratively calculate the final result.
// Time is O(n), space is O(n).

public class Solution {
    public int calculate(String s) {
        // -1 : '(', -2 : ')', -3 : '+', -4 : '-', -5 : ' '
        Stack<Integer> stack = new Stack<Integer>();
        int val = 0;
        boolean back = false;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean isNum = back || c >= '0' && c <= '9' ;
            if (isNum) {
                if (!back) {
                    int j = i;
                    while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;
                    val = Integer.parseInt(s.substring(i,j));
                    i = j -1;
                }
                else back = false;
                if (stack.empty()) {
                    stack.push(val);
                }
                else {
                    switch (stack.peek()) {
                        case -1:
                            stack.push(val);
                            break;
                        case -3:
                            stack.pop();
                            stack.push(stack.pop()+val);
                            break;
                        case -4:
                            stack.pop();
                            stack.push(stack.pop()-val);
                            break;
                        default:
                            break;
                    }
                }
            }
            else if (c == '(') stack.push(-1);
            else if (c == ')') {
                val = stack.pop();
                stack.pop();
                back = true;
                --i;
            }
            else if (c == '+') stack.push(-3);
            else if (c == '-') stack.push(-4);
        }
        return stack.peek();
    }
}
