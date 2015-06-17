//  Compare each node's left and right subtree, if the two heights are not balanced, return -1,
//  or, return the node's height by formula max(left,right)+1.
//  Using this method, we calculate each node just once by dfs.
//  Time is O(n), space is O(n).

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;
        if (Math.abs(left-right) > 1) return -1;
        return Math.max(left,right)+1;
    }
}
