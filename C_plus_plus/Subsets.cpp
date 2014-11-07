class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        vector<vector<vector<int>>> dp(S.size()+1);
        dp[0] = vector<vector<int>>(1);
        sort(S.begin(),S.end());
        for(int i = 1 ; i <= S.size() ; ++i){
            dp[i] = dp[i-1];
            for(int j = 0 ; j < dp[i-1].size() ; ++j){
                vector<int> tt = dp[i-1][j];
                tt.push_back(S[i-1]);
                dp[i].push_back(tt);
            }
        }
        return dp[S.size()];
    }
};
