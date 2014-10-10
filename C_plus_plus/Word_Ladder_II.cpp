class Solution {
public:
    struct cell{
        string s;
        int level;
        int mask;
        vector<cell *> father;
        cell(string s, int level, int mask, vector<cell * >father):s(s),level(level),mask(mask),father(father){};
    };
    vector<vector<string>> result;
    vector<vector<string>> findLadders(string start, string end, unordered_set<string> &dict) {
        int min = 2;
        vector<cell*> graph;
        vector<unordered_map<string,cell *>> levelmap;
        unordered_set<string> adj;
        vector<int> levelstart(1,0);
        int currentlevel = 1;
        for(int i = 0 ; i < start.size() ; ++i){
            string tt = start;
            for(char c = 'a' ; c <= 'z' ; ++c){
                tt[i] = c;
                adj.insert(tt);
            }
        }
        if(dict.count(start)>0) dict.erase(start);
        if(dict.count(end)>0) dict.erase(end);
        graph.push_back(new cell(end,1,-1,vector<cell *>(1)));
        unordered_map<string,cell *> dd;
        dd[end] = graph[0];
        levelmap.push_back(dd);
        int j = 0;
        bool flag = true;
        while(j<graph.size()&&flag){
            cell *str = graph[j++];
            string t = str->s;
            for(int i = 0 ; i < t.size()&&flag ; ++i){
                if(i == str->mask) continue;
                for(char c = 'a' ; c <= 'z' ; ++c){
                    if(c == t[i]) continue;
                    string s = t;
                    s[i] = c;
                    if(s == start){
                        min = str->level+1;
                        flag = false;
                        break;
                    }
                    if(dict.find(s)!=dict.end()){
                        graph.push_back(new cell(s,str->level+1,i,vector<cell *>(1,str)));
                        dict.erase(s);
                        if(currentlevel==str->level){
                            ++currentlevel;
                            levelstart.push_back(graph.size()-1);
                            unordered_map<string,cell *> ff;
                            ff[s] = graph.back();
                            levelmap.push_back(ff);
                        }
                        else{
                            unordered_map<string,cell *> ff = levelmap[currentlevel-1];
                            ff[s] = graph.back();
                            levelmap[currentlevel-1] = ff;
                        }
                    }
                    else if(str->level+1==currentlevel&&levelmap[currentlevel-1].count(s)>0){
                        levelmap[currentlevel-1][s]->father.push_back(str);
                    }
                }
            }
        }
        int endlevel;
        if(levelstart.size()>min-1) endlevel = levelstart[min-1];
        else endlevel = graph.size();
        for(int i = levelstart[min-2] ; i < endlevel; ++i){
            if(adj.count(graph[i]->s)>0){
                dsp(graph[i],vector<string>(1,start));
            }
        }
        return result;
    }
    void dsp(cell * root,vector<string> pre){
        if(root == NULL){
            result.push_back(pre);
            return;
        }
        pre.push_back(root->s);
        for(int i = 0 ; i < root->father.size(); ++i){
            dsp(root->father[i],pre);
        }
    }
};
