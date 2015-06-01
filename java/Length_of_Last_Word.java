// Be careful of the cases : "a    b   ", "a   "
// Time is O(n), space is O(1)

public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0, last = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                last = len == 0 ? last : len;
                len = 0;
            }
            else {
                len++;
            }
        }
        return len == 0 ? last : len;
    }
}
