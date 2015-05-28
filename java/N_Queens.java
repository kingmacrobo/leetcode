// BFS method with pruning
// The rules of Queen is that two Queen can't be located in the same row , column and diagonal.
// Time is O(n!), space is O(n!)

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        List<Integer> pre = new LinkedList<Integer>();
        char[] row = new char[n];
        for (int j = 0; j < n; ++j)
            row[j] = '.';
        dfs(pre, n, 0, result, row);
        return result;
    }
    public void dfs(List<Integer> pre, int n, int x, List<String[]> result, char[] row) {
        if (x == n) {
            String[] s = new String[n];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                row[pre.get(i)] = 'Q';
                s[i] = new String(row);
                row[pre.get(i)] = '.';
            }
            result.add(s);
            return;
        }
        for (int y = 0; y < n; ++y) {
            int xx = 0;
            for (; xx < pre.size(); ++xx) {
                int yy = pre.get(xx);
                if (y == yy || Math.abs(y-yy) == Math.abs(x-xx))
                    break;
            }
            if (xx == pre.size()) {
                pre.add(y);
                dfs(pre, n, x+1, result, row);
                pre.remove(pre.size()-1);
            }
        }
    }
}
