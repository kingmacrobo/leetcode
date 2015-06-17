// Recursive solution, DFS
// Move the left tree to the root's right , and the right tree to the left's tail.
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
    public void flatten(TreeNode root) {
        generate(root);
    }
    public Pack generate(TreeNode root) {
        if (root == null) return new Pack(null,null);
        if (root.left == null && root.right == null)
            return new Pack(root,root);
        Pack p1 = generate(root.left);
        Pack p2 = generate(root.right);
        root.left = null;
        if (p1.head == null) {
            root.right = p2.head;
            p2.tail.right = null;
            return new Pack(root,p2.tail);
        }
        else if (p2.head == null) {
            root.right = p1.head;
            p1.tail.right = null;
            return new Pack(root,p1.tail);
        }
        else {
            root.right = p1.head;
            p1.tail.right = p2.head;
            p2.tail.right = null;
            return new Pack(root,p2.tail);
        }
    }
    class Pack {
        TreeNode head, tail;
        public Pack(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
