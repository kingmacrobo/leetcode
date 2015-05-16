// time is O(n^2), space is O(1)
public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        for (int i = 0 ; i <= len1 - len2 ; ++i) {
            int j = 0;
            for (; j < len2 ; ++j) {
                if (haystack.charAt(j+i) != needle.charAt(j))
                    break;
            }
            if (j == len2)
                return i;
        }
        return -1;
    }
}
