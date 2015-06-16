// Divide and conquer
// Recursive solution
// Make the two parts' number counts as closet as posible.
// Time and space are both O(n).

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums,0,nums.length-1);
    }
    public TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(nums[(start+end)/2]);
        node.left = constructTree(nums,start,(start+end)/2-1);
        node.right = constructTree(nums,(start+end)/2+1,end);
        return node;
    }
}
