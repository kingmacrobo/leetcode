// Using a record array to record the latest streak after the '('
// Time is O(n), while space is also O(n), since we use a record array.
public class Solution {
    public int longestValidParentheses (String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0, len = s.length(), max = 0;
        int[] record = new int[len + 1];
        while (i < len) {
            char c = s.charAt(i++);
            if (stack.empty()) {
                if (c == ')') { 
                    if (record[0] > max) max = record[0]; 
                    record[0] = 0;
                    continue;
                }
                else stack.push(c);
            }
            else if (c == ')') {
                stack.pop();
                int index = stack.size();
                record[index] += 2 + record[index+1];
                record[index+1] = 0;
            }
            else stack.push(c);
        }
        for (i = 0 ; i < stack.size()+1 ; ++i)
            if (record[i] > max) max = record[i];
        return max;
    }
}
