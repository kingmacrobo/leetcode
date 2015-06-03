// Binary search 
// The only difference to the linear is that we should transcode the linear location to the matrix location:
//      row = linear_location/row_length, column = linear_location%row_length.
// Time is O(logm + logn), space is O(1).
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;
        while (low <= high) {
            int mid = (low+high)/2;
            int val = matrix[mid/n][mid%n];
            if (val == target) return true;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
