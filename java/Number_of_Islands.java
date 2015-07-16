// Graph, DFS
// Time is O(n^2), space is O(n^2).

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        Boolean[][] visited = new Boolean[m][n];
        int count = 0;
        for (Boolean[] v : visited)
            Arrays.fill(v, false);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                find(grid,visited,i,j);
                count++;
            }
        }
        return count;
    }
    public void find(char[][] grid, Boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        solve(grid,visited,i-1,j);
        solve(grid,visited,i+1,j);
        solve(grid,visited,i,j-1);
        solve(grid,visited,i,j+1);
    }
    public void solve(char[][] grid, Boolean[][] visited, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0) {
            if (grid[i][j] != '0' && !visited[i][j]) {
                find(grid,visited,i,j);
            }
        }
    }
}
