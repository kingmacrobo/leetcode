// LCA in a BST
// Choosing left node or right node by using the attribute of the BST.
// Time is O(logn), space is O(logn).

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        if (root.val >= max) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < min) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
