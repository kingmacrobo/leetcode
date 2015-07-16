// Inoder travel, right first!
// Using a global level to record the current deepes level, if the node's level is big than the global level,
// add the node's val to result!
// Time is O(0=n), space is O(n).

public class Solution {
    int level = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solve(result, root,1);
        return result;
    }
    public void solve(List<Integer> result, TreeNode root, int lev) {
        if (root == null) return;
        if (lev > level) {
            result.add(root.val);
            level++;
        }
        if (root.right != null) {
            solve(result,root.right,lev+1);
        }
        if (root.left != null)
            solve(result,root.left,lev+1);
    }
}
