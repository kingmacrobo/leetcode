// Recurse solution
// Firstly, preprocessing to get the existent table.
// Secondly, recurse at every (i,j) from top left to down right to find the answer!
// The worst time is O((9!)^9) if the board is empty at all!
// Let's consider the count of empty cell is n, and the average count of numbers candidate is m,
// then, the time complexity is approximately O(m^n).
// The space complexity is O(1), since we just use the contant existent table.

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][][] table = new boolean[3][9][9];
        for (int i = 0 ; i < 9 ; ++i) {
            for (int j = 0 ; j < 9 ; ++j) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                table[0][i][val] = table[1][j][val] = table[2][(i/3)*3+j/3][val] = true;
            }
        }
        deal(board,table,0,0);
    }
    
    public boolean deal(char[][] board, boolean[][][] table, int i , int j) {
        if (i == 9) return true;
        if (board[i][j] != '.') {
            return j==8 && deal(board,table,i+1,0) || j!=8 && deal(board,table,i,j+1);
        }
        for (int k = 0 ; k < 9 ; ++k) {
            if (table[0][i][k] || table[1][j][k] || table[2][(i/3)*3+j/3][k])
                continue;
            board[i][j] = (char)('1' + k) ;
            table[0][i][k] = table[1][j][k] = table[2][(i/3)*3+j/3][k] = true;
            if (j == 8 && deal(board,table,i+1,0) || j < 8 && deal(board,table,i,j+1)) {
                return true;
            }
            else {
                board[i][j] = '.' ;
                table[0][i][k] = table[1][j][k] = table[2][(i/3)*3+j/3][k] = false;
            }
        }
        return false;
    }
}
