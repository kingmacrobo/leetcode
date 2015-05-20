// Just like String compress
// Do the string compress n times.
// If the averay length is m, the time is O(mn), space is the max length of the string.
public class Solution {
    public String countAndSay(int n) {
        if (n == 0) return new String("");
        String pre = new String("1");
        for (int i = 1 ; i < n ; ++i) {
            StringBuffer s = new StringBuffer();
            char current = pre.charAt(0);
            int count = 1;
            for (int j = 1 ; j < pre.length() ; ++j) {
                char c = pre.charAt(j);
                if (c == current) count++;
                else {
                    s.append(count+""+current);
                    current = c;
                    count = 1;
                }
            }
            s.append(count+""+current);
            pre = s.toString();
        }
        return pre;
    }
}
