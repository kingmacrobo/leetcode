public class Solution {
    TrieNode root = new TrieNode();
    Set<String> set = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (boolean[] b : visited) Arrays.fill(b, false);
        for (String word : words) root.add(word, 0);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(board, i, j , visited, "");
            }
        }
        return new ArrayList<String>(set);
    }
    public void dfs(char[][] board, int i, int j, boolean[][] visited, String word) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        StringBuilder sb = new StringBuilder(word);
        sb.append(board[i][j]);
        String pre = sb.toString();
        if (!root.startWith(pre, 0)) return;
        if (root.search(pre, 0)) set.add(pre);
        visited[i][j] = true;
        dfs(board, i-1, j, visited, pre);
        dfs(board, i+1, j, visited, pre);
        dfs(board, i, j-1, visited, pre);
        dfs(board, i, j+1, visited, pre);
        visited[i][j] = false;
    }
    
    class TrieNode {
        HashMap<Character, TrieNode> table = new HashMap<Character, TrieNode>();
        boolean isWord;
        public void add(String word, int index) {
            if (index == word.length()) {
                isWord = true;
                return;
            }
            char c = word.charAt(index);
            if (!table.containsKey(c)) {
                table.put(c, new TrieNode());
            }
            table.get(c).add(word, index+1);
        }
        public boolean startWith(String word, int index) {
            if (index == word.length()) return true;
            char c = word.charAt(index);
            if (!table.containsKey(c)) return false;
            return table.get(c).startWith(word, index+1);
        }
        public boolean search(String word, int index) {
            if (index == word.length()) return isWord;
            char c = word.charAt(index);
            if (!table.containsKey(c)) return false;
            return table.get(c).search(word, index+1);
        }
    }
}
