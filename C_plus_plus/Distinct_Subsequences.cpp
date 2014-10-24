class Solution {
public:
    int numDistinct(string S, string T) {
        vector<vector<int>> record(S.size(),vector<int>(T.size(),-1));
        return dp(S,T,record);
    }
    int dp(string S, string T , vector<vector<int>> &record){
        if(!T.size()||S.size()<T.size()) return 0;
        int sum = 0;
        for(int i = 0 ; i < S.size() ; ++i){
            if(S[i] == T[0]) {
                if(T.size()>1&&i<S.size()-1){
                    if(record[S.size()-i-1][T.size()-2]==-1)
                        record[S.size()-i-1][T.size()-2] = dp(S.substr(i+1),T.substr(1),record); 
                    sum += record[S.size()-i-1][T.size()-2];
                }
                else if(T.size()==1)
                    sum += 1;
            }
        }
        return sum;        
    }
};
