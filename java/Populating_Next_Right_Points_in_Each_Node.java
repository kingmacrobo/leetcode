// Level travel of binary tree
// Time is O(n), space is O(n).
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
        if (root == null) return;
        que.offer(root);
        while (que.peek() != null) {
            for (int n = que.size(); n > 0; --n) {
                TreeLinkNode cur = que.poll();
                if (n == 1) cur.next = null;
                else cur.next = que.peek();
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
    }
}
