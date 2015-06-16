// Concise solution !
// Make each level to a list, and put it to the result list's head.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while (que.peek() != null) {
            List<Integer> list = new ArrayList<Integer>();
            for (int n = que.size(); n > 0; n--) {
                TreeNode node = que.poll();
                list.add(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            result.add(0,list);
        }
        return result;
    }
}
