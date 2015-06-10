// Recursive solution
// Time is O(n), space is O(1).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        if (p.val != q.val) return false;
        if (p.left != null || q.left != null) {
            if (p.left == null || q.left == null || !isSameTree(p.left,q.left))
                return false;
        }
        if (p.right != null || q.right != null) {
            if (p.right == null || q.right == null || !isSameTree(p.right,q.right))
                return false;
        }
        return true;
    }
}
