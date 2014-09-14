#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
public:
    vector<string> result;
    
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        string st="",rst="";
        deal(s,dict,st,rst);
        return result;
    }
    
    void deal(string s,unordered_set<string> &dict,string tmp,string rtmp)
    {
        unsigned long position,rposition;
        string str,rstr;
        for(unordered_set<string>::iterator it = dict.begin();it!=dict.end();++it)
        {
            position = 0;
            str = *it;
            string::iterator ss;
            for(ss = str.begin();ss!=str.end()&&position!=s.size();++ss,++position)
            {
                if(s[position] == *ss)
                    continue;
                break;
            }
            if(ss == str.end())
            {
                if(position==s.size())
                {
                    
                    result.push_back(tmp+str+rtmp);
                    
                }
                else
                {
                    for(unordered_set<string>::iterator itt = dict.begin();itt!=dict.end();++itt)
                    {
                        rposition = s.size()-1;
                        rstr = *itt;
                        int p = (int)rstr.size()-1;
                        for(;p >= 0&&rposition>position-1;--p,--rposition)
                        {
                            if(s[rposition] == rstr[p])
                            {
                                continue;
                            }
                            break;
                        }
                        ++rposition;
                        if(p == -1)
                        {
                            if(position==rposition)
                            {
                                result.push_back(tmp+str+" "+rstr+rtmp);
                            }
                            else
                                deal(s.substr(position,rposition-position),dict,tmp+str+" "," "+rstr+rtmp);
                            
                        }
                    }
                    
                    
                }
            }
            
        }
        
    }
    
};

int main()
{
    Solution st;
    string s = "catsanddog";
    unordered_set<string> dict = {"cat", "cats", "and", "sand", "dog"};
    vector<string> result = st.wordBreak(s,dict);
    for(vector<string>::iterator it = result.begin();it!=result.end();++it)
        cout << *it <<endl;
    return 0;
}