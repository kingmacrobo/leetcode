// Dp solution
// dp(a1,b1,a2,b2) means if the substirng (a1,b1) of s1 and substring (a2,b2) of s2 are scramble.
// formula :
//      dp(a1,b1,a2,b2) = for (int i = 0; i < b1-a1; ++i)
//                          dp(s1,s2,a1,a1+i,a2,a2+i)&&dp(s1,s2,a1+i+1,b1,a2+i+1,b2)||
//                          dp(s1,s2,a1,a1+i,b2-i,b2)&& dp(s1,s2,a1+i+1,b1,a2,b2-i-1)
// Time and space are both O(n^4)

public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int[][][][] record = new int[n][n][n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    Arrays.fill(record[i][j][k],-1);
        return isScram(s1,s2,0,n-1,0,n-1,record) == 1;
    }
    public int isScram(String s1, String s2, int a1, int b1, int a2, int b2, int[][][][] record) {
        if (record[a1][b1][a2][b2] != -1) return record[a1][b1][a2][b2];
        if (a1 == b1) return record[a1][b1][a2][b2] = s1.charAt(a1) == s2.charAt(a2) ? 1 : 0;
        for (int i = 0; i < b1-a1; ++i) {
            if (isScram(s1,s2,a1,a1+i,a2,a2+i,record) == 1 && isScram(s1,s2,a1+i+1,b1,a2+i+1,b2,record) == 1 ||
                isScram(s1,s2,a1,a1+i,b2-i,b2,record) == 1 && isScram(s1,s2,a1+i+1,b1,a2,b2-i-1,record) == 1)
                return record[a1][b1][a2][b2] = 1;
        }
        return record[a1][b1][a2][b2] = 0;
    }
}
