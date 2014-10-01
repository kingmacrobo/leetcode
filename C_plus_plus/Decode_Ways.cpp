class Solution {
public:
    int record[10000];
    int numDecodings(string s) {
        memset(record,-1,10000*sizeof(int));
        if(s.size()==0) return 0;
        return dp(s,0);
    }
    int dp(string s , int k){
        int a = 0,b = 0;
        if(k == s.size()-1) {
            if(s[k] == '0') return 0;
            return 1;
        }
        if(k == s.size()-2){
            if((s[k]=='1')||((s[k]=='2')&&(s[k+1]<='6'))) {
                if(s[k+1]=='0') return 1;
                return 2;
            }
            if(s[k]!='0'&&s[k+1]!='0') return 1;
            return 0;
        }
        if(s[k]!='0'){
            if(record[k+1]==-1) record[k+1] = dp(s,k+1);
            a = record[k+1];
        }
        if((s[k]=='1')||((s[k]=='2')&&(s[k+1]<='6'))){
            if(record[k+2]==-1) record[k+2] = dp(s,k+2);
            b = record[k+2];
        }
        return a+b;
    }
};
