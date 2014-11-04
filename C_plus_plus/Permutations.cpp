class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        int n = num.size();
        if(!n) return vector<vector<int>>();
        vector<vector<vector<int>>> dp(n);
        dp[0] = vector<vector<int> >(1,vector<int>(1,num[0]));
        for(int i = 1 ; i < n ; ++i){
            for(int j = 0 ; j < dp[i-1].size() ; ++j){
                dp[i-1][j].insert(dp[i-1][j].begin(),num[i]);
                dp[i].push_back(dp[i-1][j]);
                for(int k = 1 ; k < dp[i-1][j].size() ; ++k){
                    swap(dp[i-1][j][0],dp[i-1][j][k]);
                    dp[i].push_back(dp[i-1][j]);
                    swap(dp[i-1][j][0],dp[i-1][j][k]);
                }
            }
        }
        return dp[n-1];
    }
};
