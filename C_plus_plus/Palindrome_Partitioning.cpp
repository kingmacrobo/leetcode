class Solution {
public:
    vector<vector<string>> result;
    string str;
    bool isPalindrome[1000][1000];
    vector<vector<string>> partition(string s) {
        vector<string> t;
        str = s;
        memset(isPalindrome,false,1000000*sizeof(bool));
        for(int i = 0 ; i < s.size(); ++i){
            for(int j = 0; i-j>=0 && i+j<s.size() && s[i-j]==s[i+j] ; ++j)
                isPalindrome[i-j][i+j] = true;
            for(int j = 1; i-j+1>=0 && i+j<s.size() && s[i-j+1]==s[i+j] ; ++j)
                isPalindrome[i-j+1][i+j] = true;
        }
        dp(s,t,0);
        return result;
    }
    void dp(string s,vector<string> t,int w){
        for(int i = w ; i < s.size() ; ++i){
            if(isPalindrome[w][i]){
                t.push_back(s.substr(w,i-w+1));
                if(i == s.size()-1)
                    result.push_back(t);
                else dp(s,t,i+1);
                t.erase(t.begin()+t.size()-1);
            }
        }
    }
};
