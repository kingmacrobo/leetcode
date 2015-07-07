// Dp solution
// dp[k] represent if the substring(k,end) of s can be seperated to words in dictionary.
// Time is about O(n^2), space is O(n);

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[] record = new int[s.length()];
        Arrays.fill(record,-1);
        return dp(0,s,record,wordDict) == 1;
    }
    int dp(int k, String s, int[] record, Set<String> wordDict) {
        if (k == s.length()) return 1;
        if (record[k] != -1) return record[k];
        for (int i = k; i < s.length(); ++i) {
            String word = s.substring(k,i+1);
            if (wordDict.contains(word) && dp(i+1,s,record,wordDict) == 1) {
                return record[k] = 1;
            }
        }
        return record[k] = 0;
    }
}
