class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    def minDistance(self, word1, word2):
        dp = [[j for j in range(0, len(word2) + 1)] for i in range(0,len(word1) + 1)]
        for i in range(0, len(word2) + 1):
            dp[0][i] = i
        for i in range(0, len(word1) + 1):
            dp[i][0] = i
        for i in range(0, len(word1)):
            for j in range(0, len(word2)):
                if word1[i] == word2[j]:
                    dp[i+1][j+1] = dp[i][j]
                else:
                    dp[i+1][j+1] = min(dp[i][j] + 1, dp[i+1][j] + 1,dp[i][j+1] + 1)
        return dp[len(word1)][len(word2)]
