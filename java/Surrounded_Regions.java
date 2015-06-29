// BFS solution.
// Make bfs at each board point, and find the valid 'O' which should not be fliped to 'X'.
// Time is O(n*m), space is O(n*m).

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        boolean[][] not = new boolean[m][n];
        for (int i = 0; i < m; ++i)
            Arrays.fill(not[i], false);
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if ((i == 0 || i == m-1 || j == 0 || j == n-1) && board[i][j] == 'O' && !not[i][j])
                    flip(board,i,j,not);
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (!not[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
    }
    
    public void flip(char[][] board, int i, int j, boolean[][] not) {
        Queue<Point> que = new LinkedList<Point>();
        que.offer(new Point(i,j));
        not[i][j] = true;
        while (que.peek() != null) {
            Point p = que.poll();
            if (p.i-1 >= 0 && board[p.i-1][p.j] == 'O' && !not[p.i-1][p.j]) {
                not[p.i-1][p.j] = true;
                que.offer(new Point(p.i-1,p.j));
            }
            if (p.i+1 < board.length && board[p.i+1][p.j] == 'O' && !not[p.i+1][p.j]) {
                not[p.i+1][p.j] = true;
                que.offer(new Point(p.i+1,p.j));
            }
            if (p.j-1 >= 0 && board[p.i][p.j-1] == 'O' && !not[p.i][p.j-1]) {
                not[p.i][p.j-1] = true;
                que.offer(new Point(p.i,p.j-1));
            }
            if (p.j+1 < board[0].length && board[p.i][p.j+1] == 'O' && !not[p.i][p.j+1]) {
                not[p.i][p.j+1] = true;
                que.offer(new Point(p.i,p.j+1));
            }
        }
    }
    
    class Point {
        int i;
        int j;
        public Point (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
