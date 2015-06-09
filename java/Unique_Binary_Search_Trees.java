// Dp solution
// dp(a,b) = Σ (dp(a,i-1)*dp(i+1,b)), 1<= i <= n,   dp(a,b) = 1 when a >= b.
// Time : see Catalan number : http://en.wikipedia.org/wiki/Catalan_number

public class Solution {
    public int numTrees(int n) {
        int[][] record = new int[n+1][n+1];
        for (int i = 0; i <= n; ++i)
            Arrays.fill(record[i],-1);
        return count(1,n,record);
    }
    public int count(int a, int b, int[][] record) {
        if (a > b) return 1;
        if (record[a][b] != -1) return record[a][b];
        if (a == b) return record[a][b] = 1;
        int result = 0;
        for (int i = a; i <= b; ++i) {
            int left = count(a,i-1,record);
            int right = count(i+1,b,record);
            result += left*right;
        }
        return record[a][b] = result;
    }
}
