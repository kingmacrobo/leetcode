class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if(s1.size()+s2.size()!=s3.size()) return false;
        vector<vector<vector<short>>> record(s1.size(),vector<vector<short>>(s2.size(),vector<short>(s3.size(),-1)));
        return dp(record,s1,s2,s3,0,0,0);
    }
    short dp(vector<vector<vector<short>>> &record, string &s1, string &s2, string &s3, int loc1, int loc2, int loc3){
        if(loc1==s1.size()){
            if(s2.substr(loc2)==s3.substr(loc3)) return 1;
            else return 0;
        }
        if(loc2==s2.size()){
            if(s1.substr(loc1)==s3.substr(loc3)) return 1;
            else return 0;
        }
        if(record[loc1][loc2][loc3]!= -1)
            return record[loc1][loc2][loc3];
        for(int i = loc3,j = loc2; i < s3.size(); ++i){
            if(s1[loc1]==s3[i]){
                if(dp(record,s1,s2,s3,loc1+1,j,i+1))
                    return record[loc1][loc2][loc3] = 1;
            }
            if(j==s2.size()||s2[j++]!=s3[i]) return record[loc1][loc2][loc3] = 0;
        }
        return record[loc1][loc2][loc3] = 0;
    }
};
