// Just one line code !
// Time is O(n), space is O(n);
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
