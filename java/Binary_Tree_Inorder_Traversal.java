// Iteration soltuion
// Using stack and hashmap
// HashMap to record if the node is visited .
// Time is O(n), space is O(n).

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<TreeNode,Boolean> visited = new HashMap<TreeNode,Boolean>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (visited.containsKey(node)) {
                result.add(node.val);
                continue;
            }
            if (node.right != null) stack.push(node.right);
            visited.put(node,true);
            stack.push(node);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}
