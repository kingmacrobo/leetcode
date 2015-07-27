// DFS solution.
// Using a count to record the nodes left, if we find the count is 0, we stop the search.
// Time is O(n), space is O(n).

public class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root, p, q, 2);
        return result;
    }
    public int solve(TreeNode root, TreeNode p, TreeNode q, int count) {
        if (root == null) return count;
        if (count == 1) {
            if (root == p || root == q) return 0;
            int left = solve(root.left, p, q, count);
            if (left == 0) return 0;
            int right = solve(root.right, p, q, count);
            if (right == 0) return 0;
            return 1;
        }
        else if (count == 2) {
            int remain = 2;
            if (root == p || root == q) remain--;
            int left = solve(root.left, p, q, remain);
            if (left == 0) {
                if (remain == 1) result = root;
                return 0;
            }
            int right = solve(root.right, p, q, left);
            if (right == 0)  {
                if (remain == 1 || remain == 2 && left == 1) 
                    result = root;
                return 0;
            }
            if (remain == 1) return 1;
            else if (left == 1 && right == 1 || left == 2 && right == 1)
                return 1;
        }
        return 2;
    }
}


// Below is the best solution of LCA:
// Time is O(n), space is O(n).

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
