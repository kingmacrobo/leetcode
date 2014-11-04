class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<vector<vector<string>>> record(n+1,vector<vector<string>>(n+1));
        return dp(record,n,0);
    }
    vector<string> dp(vector<vector<vector<string>>> &record, int n , int pre){
        if(record[n][pre].size())
            return record[n][pre];
        vector<string> result;
        if(n==pre){
            string a(n,'('),b(n,')');
            result.push_back(a+b);
            return record[n][pre] = result;
        }
        if(pre==0){
            for(int j = n ; j >= 1 ; --j){
                vector<string> temp = dp(record,n,j);
                for(int i = 0 ; i < temp.size() ; ++i)
                    result.push_back(temp[i]);
            }
            return result;
        }
        for(int j = n-1 ; j>0 && j >= pre-1 ; --j){
            vector<string> temp = dp(record,n-1,j);
            for(int i = 0 ; i < temp.size() ; ++i){
                temp[i].insert(temp[i].begin()+pre-1,')');
                temp[i].insert(temp[i].begin()+pre-1,'(');
                result.push_back(temp[i]);
            }
        }
        return record[n][pre] = result;
    }
};
