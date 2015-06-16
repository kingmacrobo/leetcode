// Recursive solution
// Find the mid node by search the first val of preoder in inorder, and then divide into two part.
// Do the subproblem in the two part.
// Time is O(n^2), space is O(n).

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new LinkedList<Integer>();
        for (int i = 0; i < preorder.length; ++i)
            pre.add(preorder[i]);
        return constructTree(pre, inorder, 0, inorder.length-1);
    }
    public TreeNode constructTree(List<Integer> pre, int[] inorder, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(pre.get(0));
        int i = start;
        for (; i <= end; ++i)
            if (inorder[i] == pre.get(0))
                break;
        pre.remove(0);
        node.left = constructTree(pre, inorder, start, i-1);
        node.right = constructTree(pre, inorder, i+1, end);
        return node;
    }
}
