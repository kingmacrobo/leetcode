// Recursive solution
// Find the mid node by search the postorder last node in inorder sequence, and divide it to two parts.
// Do the same job in the two subproblem.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    public TreeNode constructTree(int[] inorder, int start, int end, int[] postorder, int index) {
        if (start > end) return null;
        int i = start;
        for (; i <= end; ++i)
            if (inorder[i] == postorder[index])
                break;
        TreeNode node = new TreeNode(postorder[index]);
        node.right = constructTree(inorder,i+1,end,postorder,index-1);
        node.left = constructTree(inorder,start,i-1,postorder,index-1-end+i);
        return node;
    }
}
