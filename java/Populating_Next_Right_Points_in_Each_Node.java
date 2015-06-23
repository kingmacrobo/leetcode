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

// We can also solve this problem in O(1) space :
// The method below can suit any binary tree.

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
        TreeLinkNode p = root, first = null, pre = null;;
        int curCount = 1, nextCount = 0, cur = 0;
        while (p != null) {
            if (p.left != null) {
                if (pre == null) {
                    pre = p.left;
                    first = p.left;
                }
                else {
                    pre.next = p.left;
                    pre = p.left;
                }
                nextCount++;
            }
            if (p.right != null) {
                if (pre == null) {
                    pre = p.right;
                    first = p.right;
                }
                else {
                    pre.next = p.right;
                    pre = p.right;
                }
                nextCount++;
            }
            
            if (++cur == curCount) {
                p.next = null;
                cur = 0;
                curCount = nextCount;
                nextCount = 0;
                p = first;
                first = pre = null;
            }
            else
                p = p.next;
            
        }
    }
}
