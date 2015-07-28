// Search from the top right to the bottom left.
// Time is O(m+n), space is O(1).

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }
}
