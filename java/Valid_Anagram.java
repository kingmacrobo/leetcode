// Hash table
// Time is O(n), space is O(1).

public class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (t.length() != n) return false;
        int[] table = new int[26];
        Arrays.fill(table,0);
        for (int i = 0; i < s.length(); ++i) {
            table[s.charAt(i)-'a']++;
            table[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; ++i)
            if (table[i] != 0)
                return false;
        return true;
    }
}
