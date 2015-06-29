// DFS method
// Time is O(n), space is O(n).

public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root, int preValue) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return preValue*10 + root.val;
        return dfs(root.left, preValue*10 + root.val) + dfs(root.right, preValue*10 + root.val);
        
    }
}
