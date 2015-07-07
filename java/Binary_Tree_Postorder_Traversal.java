// Iterator + hashset solution
// Time is O(n), space is O(n).

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode t = stack.pop();
            if (visited.contains(t)) {
                result.add(t.val);
                continue;
            }
            visited.add(t);
            stack.push(t);
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
        return result;
    }
}
