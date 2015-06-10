// Recursive solution
// Using [min,max] to restrict the current node's segment.
// We use long to avoid the overflow cases.
// Time is O(n), space is O(n);

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
    public boolean isValidBST(TreeNode root) {
        long max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        return isValid(root, max+1, min-1);
    }
    public boolean isValid(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.left != null) {
            long new_max = Math.min(root.val,max);
            if (root.left.val >= new_max || root.left.val <= min  || !isValid(root.left,new_max,min)) 
                return false;
        }
        if (root.right != null) {
            long new_min = Math.max(root.val,min);
            if (root.right.val <= new_min || root.right.val >= max || !isValid(root.right,max,new_min))
                return false;
        }
        return true;
    }
}
