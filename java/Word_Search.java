// DFS, Backtracking

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                visited[i][j] = false;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i,j,0,visited,board,word))
                        return true;
                }
            }
        return false;
    }
    boolean dfs(int x, int y, int index, boolean[][] visited, char[][] board, String word) {
        if (board[x][y] == word.charAt(index)) {
            if (index == word.length()-1) return true;
            visited[x][y] = true;
            boolean ret = false;
            if (x+1 < board.length && !visited[x+1][y])
                ret |= dfs(x+1,y,index+1,visited,board,word);
            if (x-1 >= 0 && !visited[x-1][y])
                ret |= dfs(x-1,y,index+1,visited,board,word);
            if (y+1 < board[0].length && !visited[x][y+1])
                ret |= dfs(x,y+1,index+1,visited,board,word);
            if (y-1 >= 0 && !visited[x][y-1])
                ret |= dfs(x,y-1,index+1,visited,board,word);
            if (ret) return true;
            visited[x][y] = false;
        }
        return false;
    }
}
