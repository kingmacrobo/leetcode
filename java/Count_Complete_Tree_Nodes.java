// Binary Search Method
// Check the the tree height firstly, let's take it as h, and then check the right tree's height, let's
// take it as h_left.
// If h_left == h - 1, we can prove that the left tree is complete, so we calculate the left tree's nodes, and add it to the total nodes count.
//                     And then we just make it a subproblem at the right node.
// else if h_left != h - 1, we can prove that the right tree is complete with height h-2, so we calculte the right tree's nodes, and add it to the total nodes count.
//                     And then we just make it a subproblem at the left node.
// Time is O((logn)^2) since we check at one node at one level with caculating the height, 
// space is O(logn) since we use recursive method.

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
    public int countNodes(TreeNode root) {
        int height = countHeight(root);
        if (height == 0) return 0;
        if (countHeight(root.right)+1 == height)
            return (1 << (height-1)) -1 + countNodes(root.right) + 1;
        else
            return (1 << (height-2)) -1 + countNodes(root.left) + 1;
    }
    public int countHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
}
