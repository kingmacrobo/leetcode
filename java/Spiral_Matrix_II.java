// pass the matrix by spiralling movement
// Time is O(n^2), space is O(n^2)

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        int val = 1;
        for (int k = 0; k < (n+1)/2; ++k) {
            for (int i = k; i < n-k; ++i) {
                spiral[k][i] = val++;
            }
            for (int i = k+1; i < n-k; ++i) {
                spiral[i][n-k-1] = val++;
            }
            for (int i = n-k-2; i >= k && k < n-k-1; --i) {
                spiral[n-k-1][i] = val++;
            }
            for (int i = n-k-2; i >= k+1 && k < n-k-1; --i) {
                spiral[i][k] = val++;
            }
        }
        return spiral;
    }
}
