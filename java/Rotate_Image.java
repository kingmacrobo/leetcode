// Using the formula below to rotate 90 degrees:
//    (x,y) = > (y,n-x-1)
// Time is O(n^2), space is O(1)

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < (n+1)/2; ++j) {
                int a = i, b = j;
                int origin = matrix[a][b];
                for (int k = 0; k < 4; ++k) {    
                    int temp = matrix[b][n-a-1];                
                    matrix[b][n-a-1] = origin;
                    origin = temp;
                    int aa = a;
                    a = b;
                    b = n-aa-1;
                }
            }
        }
    }
}
