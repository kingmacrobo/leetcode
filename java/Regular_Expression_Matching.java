// this is one of the most defficult leetcode
// use dp
// dp[i][j] represents if the S.substring(i) equals to P.substring(j)
// there are a lot of situations that we should carefully consider.

public class Solution {
public boolean isMatch(String s, String p) {
		int[][] record = new int[s.length()][p.length()];
		for (int i = 0; i < s.length(); ++i)
			for (int j = 0; j < p.length(); ++j)
				record[i][j] = -1;
		return dp(s, p, 0, 0, record) == 1;
	}
	public int dp(String s, String p, int i, int j, int[][] record) {
		if (i < s.length() && j == p.length()) return 0;
		if (i == s.length() && j < p.length()) {
			if (p.charAt(j) == '*')  ++j;
			while (j < p.length()) {
				if (j + 1 >= p.length() || p.charAt(j + 1) != '*') return 0;
				j += 2;
			}
			return 1;
		}
		if (i == s.length() && j == p.length()) return 1;
		if (record[i][j] != -1) return record[i][j];
		if (s.charAt(i) == p.charAt(j)) {
			if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
				if (dp(s, p, i, j + 2, record) == 1)
					return record[i][j] = 1;
			}
			return record[i][j] = dp(s, p, i + 1, j + 1, record);
		}
		if (p.charAt(j) == '*') {
			int k = i;
			if (k < 1) return record[i][j] = 0;
			while (k < s.length() && s.charAt(k) == s.charAt(k - 1)) {
				if (dp(s, p, k, j + 1, record) == 1)
					return record[i][j] = 1;
				++k;
			}
			return record[i][j] = dp(s, p, k, j + 1, record);
		}
		if (p.charAt(j) == '.') {
			if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
				for (int k = i + 1; k <= s.length(); ++k) {
					if (dp(s, p, k, j + 2, record) == 1) 
						return record[i][j] = 1;
				}
			} else 
				return record[i][j] = dp(s, p, i + 1, j + 1, record);
		}
		if (j + 1 < p.length() && p.charAt(j + 1) == '*') 
			return record[i][j] = dp(s, p, i, j + 2, record);
		return record[i][j] = 0;
	}
}
