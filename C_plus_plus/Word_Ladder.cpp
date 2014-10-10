class Solution {
public:
    int ladderLength(string start, string end, unordered_set<string> &dict) {
        queue<string> que;
        unordered_map<string, int> level;
        que.push(start);
        level[start] = 1;
        while(!que.empty()){
            string t = que.front();
            que.pop();
            for(int i = 0 ; i < t.size() ; ++i){
                for(char c = 'a' ; c <= 'z' ; ++c){
                    if(c == t[i]) continue;
                    string s = t;
                    s[i] = c;
                    if(s == end) return level[t]+1;
                    if(dict.find(s)!=dict.end()){
                        que.push(s);
                        level[s] = level[t]+1;
                        dict.erase(dict.find(s));
                    }
                }
            }
        }
        return 0;
    }
};
