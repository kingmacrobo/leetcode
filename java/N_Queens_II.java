// DFS with pruning
// Time is O(n!), space is O(n)

public class Solution {
    public int totalNQueens(int n) {
        List<Integer> pre = new LinkedList<Integer>();
        return dfs(pre, n, 0);
    }
    public int dfs(List<Integer> pre, int n, int x) {
        if (x == n) return 1;
        int result = 0;
        for (int y = 0; y < n; ++y) {
            int xx = 0;
            for (; xx < pre.size(); ++xx) {
                int yy = pre.get(xx);
                if (y == yy || Math.abs(y-yy) == Math.abs(x-xx))
                    break;
            }
            if (xx == pre.size()) {
                pre.add(y);
                result += dfs(pre, n, x+1);
                pre.remove(pre.size()-1);
            }
        }
        return result;
    }
}
