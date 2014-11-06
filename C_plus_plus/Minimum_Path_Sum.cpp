class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        if(!grid.size()||!grid[0].size()) return 0;
        vector<vector<int>> dp(grid.size()+1,vector<int>(grid[0].size()+1,INT_MAX));
        int m = grid.size() , n = grid[0].size();
        dp[0][1] = dp[1][0] = 0;
        for(int i = 1 ; i < m + 1 ; ++i)
            for(int j = 1 ; j < n + 1 ; ++j){
                dp[i][j] = grid[m-i][n-j] + min(dp[i][j-1],dp[i-1][j]);
            }
        return dp[m][n];
    }
};
