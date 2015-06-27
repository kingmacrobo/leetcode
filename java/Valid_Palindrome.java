// Two pointer, one pass!
// Time is O(n), space is O(1).

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (!isAlphaNum(a)) {
                ++i;
                continue;
            }
            if (!isAlphaNum(b)) {
                --j;
                continue;
            }
            if (a >= '0' && a <= '9') {
                if (a != b) return false;
            }
            else {
                if (Character.toLowerCase(a) != Character.toLowerCase(b))
                    return false;
            }
            ++i;
            --j;
        }
        return true;
    }
    public boolean isAlphaNum(char c) {
        char cc = Character.toLowerCase(c);
        if (c >= '0' && c <= '9' || cc >= 'a' && cc <= 'z')
            return true;
        return false;
    }
}
