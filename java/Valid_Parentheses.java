// using stack and hash to do it
// time is O(n), space is O(n)
public class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<Character>();
       HashMap<Character,Character> table = new HashMap<Character,Character>(){{
            put(')','(');put('}','{');put(']','[');}};
       if (s.length() == 0) return true;
       stack.push(s.charAt(0)) ;
       for (int i = 1 ; i < s.length() ; ++i) {
           if (!stack.empty() && table.get(s.charAt(i)) == stack.peek()) {
               stack.pop();
           }
           else {
               stack.push(s.charAt(i));
           }
       }
       return stack.empty();
    }
}
