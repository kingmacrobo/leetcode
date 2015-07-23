// Stack method.
// Calculating the express from left to right via a stack.
// Time is O(n), space is O(n).

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1, result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                int val = 0;
                int j = i;
                while (j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0') ++j;
                val = Integer.parseInt(s.substring(i,j));
                i = j-1;
                stack.push(val);
            }
            else if (c != ' ') {
                int k = i + 1;
                while (k < s.length() && s.charAt(k) == ' ') ++k;
                int j = k;
                while(j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0') ++j;
                int val = Integer.parseInt(s.substring(k,j));
                switch (c) {
                    case '+':
                        result += sign * stack.pop();
                        sign = 1;
                        break;
                    case '-':
                        result += sign * stack.pop();
                        sign = -1;
                        break;
                    case '*':
                        stack.push(stack.pop() * val);
                        i = j-1;
                        break;
                    case '/':
                        stack.push(stack.pop() / val);
                        i = j-1;
                        break;
                }
            }
        }
        if (!stack.empty()) result += sign*stack.peek();
        return result;
    }
}
