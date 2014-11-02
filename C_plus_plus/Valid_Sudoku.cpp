class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        vector<vector<vector<bool>>> table(3,vector<vector<bool>>(9,vector<bool>(10,false)));
        for(int i = 0 ; i < 9 ; ++i)
            for(int j = 0 ; j < 9 ; ++j){
                if(board[i][j] == '.') continue;
                if(table[0][i][board[i][j]-'0']) return false;
                if(table[1][j][board[i][j]-'0']) return false;
                if(table[2][3*(i/3)+j/3][board[i][j]-'0']) return false;
                table[0][i][board[i][j]-'0'] = true;
                table[1][j][board[i][j]-'0'] = true;
                table[2][3*(i/3)+j/3][board[i][j]-'0'] = true;
            }
        return true;
    }
};
