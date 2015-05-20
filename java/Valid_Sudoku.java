// use a table to record the val already passed.
// just scan the board once !
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] table = new boolean[3][9][9];
        for (int i = 0; i < 9 ; ++i) {
            for (int j = 0; j < 9 ; ++j) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0'-1;
                if (table[0][i][val] || table[1][j][val] || table[2][(i/3)*3 + j/3][val]) 
                    return false;
                table[0][i][val] = table[1][j][val] = table[2][(i/3)*3 + j/3][val] = true;
            }
        }
        return true;     
    }
}
