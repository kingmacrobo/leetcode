// DFS solution
// Calculate all the submax sum that contains node i, and compare with the global max.
// Time is O(n), space is O(n).

public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }
    public int findMax(TreeNode root) {
        if (root == null) return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);
        int ret = Math.max(Math.max(left,right),0) + root.val;
        int pass = left + right + root.val;
        int submax = Math.max(ret,pass);
        if (submax > max) max = submax;
        return ret;
    }
}
