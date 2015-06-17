// DFS
// creating the sub problem by the subtrees of the node.
// Time is O(n), space is O(n).

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        boolean result = false;
        if (root.left != null)
            result |= hasPathSum(root.left, sum - root.val);
        if (root.right != null) {
            result |= hasPathSum(root.right, sum - root.val);
        }
        return result;
    }
}
