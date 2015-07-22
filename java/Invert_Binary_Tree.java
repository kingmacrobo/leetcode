// Google: 90% of our engineers use the software you wrote (Homebrew), 
// but you can’t invert a binary tree on a whiteboard so fuck off.
// Recursive solution.
// Time is O(n), space is O(n).

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = right;
        root.right = left;
        invert(left);
        invert(right);
    }
}
