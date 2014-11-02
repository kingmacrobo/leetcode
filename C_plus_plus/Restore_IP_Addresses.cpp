class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        if(s.size()==0) return vector<string>();
        vector<vector<vector<string>>> record(5,vector<vector<string>>(s.size()));
        dp(4,0,s,record);
        return record[4][0];
    }
    vector<string> dp(int remain, int loc , string &s , vector<vector<vector<string>>> &record){
        if(record[remain][loc].size())
            return record[remain][loc];
        vector<string> a;
        if(remain<1&&s.size()>loc) return record[remain][loc] = a;
        if(loc+1<s.size()){
            vector<string> s1 = dp(remain-1,loc+1,s,record);
            if(s1.size()){
                for(int i = 0; i < s1.size(); ++i){
                    s1[i].insert(s1[i].begin(),'.');
                    s1[i].insert(s1[i].begin(),s[loc]);
                    a.push_back(s1[i]);
                }
            }
        }
        else if(remain==1&&loc+1==s.size())
            a.push_back(string(1,s[loc]));
        if(s[loc]!='0'&&loc+2<s.size()){
            vector<string> s2 = dp(remain-1,loc+2,s,record);
            if(s2.size()){
                for(int i = 0; i < s2.size(); ++i){
                    s2[i].insert(s2[i].begin(),'.');
                    s2[i].insert(s2[i].begin(),s[loc+1]);
                    s2[i].insert(s2[i].begin(),s[loc]);
                    a.push_back(s2[i]);
                }
            }
        }
        else if(s[loc]!='0'&&remain==1&&loc+2==s.size())
            a.push_back(s.substr(loc,2));
        if((s[loc]=='1'||s[loc]=='2')&&loc+2<s.size()){
            int k = (s[loc]-'0')*100+(s[loc+1]-'0')*10+s[loc+2]-'0';
            if(k>255) return record[remain][loc] = a;
            if(loc+3<s.size()){
                vector<string> s3 = dp(remain-1,loc+3,s,record);
                if(s3.size()){
                    for(int i = 0; i < s3.size(); ++i){
                        s3[i].insert(s3[i].begin(),'.');
                        s3[i].insert(s3[i].begin(),s[loc+2]);
                        s3[i].insert(s3[i].begin(),s[loc+1]);
                        s3[i].insert(s3[i].begin(),s[loc]);
                        a.push_back(s3[i]);
                    }
                }
            }
            else if(remain==1&&loc+3==s.size())
                a.push_back(s.substr(loc,3));
        }
        return record[remain][loc] = a;
    }
};
