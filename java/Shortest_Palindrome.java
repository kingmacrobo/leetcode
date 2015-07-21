// KMP method!
// Firstly, contruct the new String f : s + " " + s.reverse().
// Then, what we should do is to find the max length of the common prefix and suffix of f.
// The process is just the process of generating next arrays in KMP method!
// Time is O(n), space is O(n).

public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) return s;
        String f = s + " " + new StringBuilder(s).reverse().toString();
        int n = f.length(), j = 0;
        int[] next = new int[n+1];
        next[0] = next[1] = 0;
        for (int i = 1; i < n; ++i) {
            while (j > 0 && f.charAt(i) != f.charAt(j))
                j = next[j];
            if (f.charAt(i) == f.charAt(j)) ++j;
            next[i+1] = j;
        }
        return new StringBuilder(s.substring(next[n])).reverse().toString() + s;
    }
}
