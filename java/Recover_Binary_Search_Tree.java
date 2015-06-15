// Morris travesal method
// Thread travesal 
// Find the two incorrect position of the mid traversal list, and then swap the value of the two nodes
// Time is O(n), space is O(1).

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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, wrong1 = null, wrong2 = null, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && pre.val > cur.val) {
                    if (wrong1 == null) {
                        wrong1 = pre;
                    }
                    wrong2 = cur;                  
                }
                pre = cur; 
                cur = cur.right;
            }
            else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (cur == p.right) {
                    p.right = null;
                    if (pre != null && pre.val > cur.val) {
                        if (wrong1 == null) 
                            wrong1 = pre;
                        wrong2 = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
                else {
                    p.right = cur;
                    cur = cur.left;
                }
            }   
                   
        }
        int val = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = val;
    }
}
