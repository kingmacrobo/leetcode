// Stack iterator solution
// Time is O(n), space is O(n).

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode t = stack.pop();
            result.add (t.val);
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
        return result;
    }
}
