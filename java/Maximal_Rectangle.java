// DP solution
// dp(i,j) means the maximalRectangle of (i,j) - > (m-1,n-1), where m is the row count of matrix, n is the column count of matrix.
// recursive formula :
//    we define a submax(i,j), 
//    if matrix[i][j] == '1', we research the submax rectangle containing point (i,j), and set the submax to be the submax(i,j) val.
//    else we set the submax to be 0.
/     Then, the recursive formula can be this :
//        dp(i,j) = max {submax(i,j), max {dp(i+1,j), dp(i,j+1)}}
// Time is O(n^4), space is O(n^2).

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length; 
        int[][] record = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                record[i][j] = -1;
        return dp(0,0,m,n,matrix,record);  
    }
    int dp(int x, int y, int m, int n, char[][] matrix, int[][] record) {
        if (x >= m || y >= n) return 0;
        if (record[x][y] != -1) return record[x][y];
        int submax = 0;
        if (matrix[x][y] == '1') {
            int end = y, low = m;
            while (end < n && matrix[x][end] == '1') end++;
            for (int k = y; k < end; ++k) {
                for (int w = x; w < low; ++w) {
                    if (matrix[w][k] != '1') {
                        low = w;
                        break;
                    }
                }
                if (submax < (k-y+1)*(low-x))
                    submax = (k-y+1)*(low-x);
            }
        }
        return record[x][y] = Math.max(submax, Math.max(dp(x+1,y,m,n,matrix,record),dp(x,y+1,m,n,matrix,record))); 
    }
}
