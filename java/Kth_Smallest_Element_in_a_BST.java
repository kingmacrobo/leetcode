// Inorder  traversal of BST.
// Time is O(n), space is O(n).

public class Solution {
    int index = 0, val = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return val;
    }
    public boolean dfs(TreeNode root, int k) {
        if (root.left != null)
            if (dfs(root.left,k)) return true;
        if (++index == k) {
            val = root.val;
            return true;
        }
        if (root.right != null)
            if (dfs(root.right,k)) return true;
        return false;
    }
}
