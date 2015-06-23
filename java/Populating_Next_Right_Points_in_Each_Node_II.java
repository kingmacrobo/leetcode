// connect the next level when we are in the current level.
// Time is O(n), Space is O(1).

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
