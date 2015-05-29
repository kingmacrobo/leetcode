// First calculate how many circles in the matrix : circles = (Math.min(n,m)+1)/2
// And then, pass each circle to give the answer.
// Time is O(n*m), space is O(n*m).
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        int circles = (Math.min(n,m)+1)/2;
        for (int k = 0; k < circles; ++k) {
            for (int i = k; i < n-k; ++i)
                result.add(matrix[k][i]);
            for (int i = k+1; i < m-k; ++i)
                result.add(matrix[i][n-k-1]);
            for (int i = n-k-2; i >= k && m-k-1 > k; --i)
                result.add(matrix[m-k-1][i]);
            for (int i = m-k-2; i >= k+1 && k < n-k-1; --i)
                result.add(matrix[i][k]);
        }
        return result;
    }
}
