class Solution {
public:
    void solve(vector<vector<char>> &board) {
        if(board.size()<=2||board[0].size()<=2) return;
        stack<pair<int,int>> s;
        int xsize = board.size(), ysize = board[0].size();
        vector<vector<bool>> record(xsize,vector<bool>(ysize,false));
        vector<pair<int,int>> canlist;
        bool can = true;
        for(int i = 1 ; i < xsize-1 ; ++i){
            for(int j = 1 ; j < ysize-1 ; ++j){
                if(board[i][j] == 'O'&&!record[i][j]){
                    can = true;
                    s.push(make_pair(i,j));
                    canlist.push_back(make_pair(i,j));
                    record[i][j] = true;
                    while(!s.empty()){
                        pair<int,int> p = s.top();
                        s.pop();
                        if(can&&(p.first==0||p.first==xsize-1||p.second==0||p.second==ysize-1))
                            can = false;
                        if((p.first>0)&&board[p.first-1][p.second]=='O'&&!record[p.first-1][p.second]){
                            s.push(make_pair(p.first-1,p.second));
                            record[p.first-1][p.second] = true;
                            canlist.push_back(make_pair(p.first-1,p.second));
                        }
                        if((p.first<xsize-1)&&board[p.first+1][p.second]=='O'&&!record[p.first+1][p.second]){
                            s.push(make_pair(p.first+1,p.second));
                            record[p.first+1][p.second] = true;
                            canlist.push_back(make_pair(p.first+1,p.second));
                        }
                        if((p.second>0)&&board[p.first][p.second-1]=='O'&&!record[p.first][p.second-1]){
                            s.push(make_pair(p.first,p.second-1));
                            record[p.first][p.second-1] = true;
                            canlist.push_back(make_pair(p.first,p.second-1));
                        }
                        if((p.second<ysize-1)&&board[p.first][p.second+1]=='O'&&!record[p.first][p.second+1]){
                            s.push(make_pair(p.first,p.second+1));
                            record[p.first][p.second+1] = true;
                            canlist.push_back(make_pair(p.first,p.second+1));
                        }
                    }
                    if(can){
                        for(int w = 0 ; w < canlist.size() ; ++w)
                            board[canlist[w].first][canlist[w].second] = 'X';
                    }
                    canlist.clear();
                }
            }
        }
    }
};
