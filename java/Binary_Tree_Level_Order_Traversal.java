// Queue method
// Using current level's count and next level's count to record the length of the two level operated.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null) return result;
        int count = 1, cur = 0, next = 0;;
        que.offer(root);
        while (que.peek() != null) {
            TreeNode node = que.poll();
            list.add(node.val);
            if (node.left != null) {
                que.offer(node.left); 
                next++;
            }
            if (node.right != null) {
                que.offer(node.right);
                next++;
            }
            if (++cur == count) {
                result.add(list);
                list = new ArrayList<Integer>();
                count = next;
                next = cur = 0;
                
            }
        }
        return result;
    }
}
