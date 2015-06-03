// Edit Distance, DP solution
// edit(i,j) means the minimum distance of substring (1,i) of word1 and substring (1,j) of word2.
// the recurse formula is :
//    edit(0,0) = 0
//    edit(0,j) = j
//    edit(i,0) = i
//    edit(i,j) = min{edit(i-1,j)+1, edit(i,j-1)+1, edit(i-1,j-1) + value}, i >=1, j>=1, 
//    if word.charAt(i) == word.charAt(j), value = 0, or value = 1.
// Time and space are both O(n^2).

public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] edit = new int[n+1][m+1];
        edit[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            edit[i][0] = i;
        }
        for (int i = 1; i <= m; ++i) {
            edit[0][i] = i;
        }
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j) {
                int up_left = Math.min(edit[i-1][j],edit[i][j-1]) + 1;
                int diagonal = edit[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1))
                    diagonal++;
                edit[i][j] = Math.min(up_left,diagonal);
            }
        return edit[n][m];
    }
}
