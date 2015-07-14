// 26 denary
// Time is O(n), space is O(1).

public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            result = result*26 + s.charAt(i)-'A'+1;
        }
        return result;
    }
}
