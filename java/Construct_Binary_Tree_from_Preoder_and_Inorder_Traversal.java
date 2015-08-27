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

// We can accelerate the process by using index, other than the LinkedList.
// Time is also O(n^2), space is O(n).

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder,0, inorder, 0, inorder.length-1);
    }
    public TreeNode constructTree(int[] pre, int index, int[] inorder, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(pre[index]);
        int i = start;
        for (; i <= end; ++i)
            if (inorder[i] == pre[index])
                break;
        node.left = constructTree(pre,index+1, inorder, start, i-1);
        node.right = constructTree(pre,index+i-start+1,inorder, i+1, end);
        return node;
    }
}


// Using hashtable to optimize the search of inorder array:

public class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> loc = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) loc.put(inorder[i], i);
        return construct(preorder,inorder, 0, inorder.length-1, loc);
    }
    public TreeNode construct(int[] preorder, int[] inorder, int i, int j, HashMap<Integer, Integer> loc) {
        if (i > j) return null;
        TreeNode node = new TreeNode(preorder[index++]);
        int k = loc.get(node.val);
        node.left = construct(preorder, inorder, i, k-1, loc);
        node.right = construct(preorder, inorder, k+1, j, loc);
        return node;
    }
}
