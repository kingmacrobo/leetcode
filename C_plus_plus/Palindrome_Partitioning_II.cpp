class Solution {
public:
    int minCut(string s) {
        vector<int> dp(s.size()+1,0);
        vector<vector<bool>> isPalindrome(s.size(),vector<bool>(s.size(),false));
        for(int i = 0 ; i < s.size(); ++i){
            for(int j = 0; i-j>=0 && i+j<s.size() && s[i-j]==s[i+j] ; ++j)
                isPalindrome[i-j][i+j] = true;
            for(int j = 1; i-j+1>=0 && i+j<s.size() && s[i-j+1]==s[i+j] ; ++j)
                isPalindrome[i-j+1][i+j] = true;
        }
        dp[0] = -1;
        for(int i = 0 ; i < s.size() ; ++i){
            dp[i+1] = i;
            for(int j = 0 ; j <= i ; ++j)
                if(isPalindrome[j][i]) dp[i+1] = min(dp[i+1],dp[j]+1);
        }
        return dp[s.size()];
    }
};
