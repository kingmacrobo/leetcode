// DFS
// conver the list to array firstly.
// Time and space are both O(n).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<Integer>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return construct(nums,0,nums.size()-1);
    }
    public TreeNode construct(List<Integer> nums, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(nums.get((start+end)/2));
        node.left = construct(nums,start,(start+end)/2-1);
        node.right = construct(nums,(start+end)/2+1,end);
        return node;
    }
}

// we can also construct the tree first and then set the values to the tree,
// in which we just pass the list twice.
// Time is O(n), space is O(n).

public class Solution {
    private ListNode p = null;
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode node = head;
        p = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        if (count == 0) return null;
        TreeNode root = constructTree(count);
        setTree(root);
        return root;
    }
    public TreeNode constructTree(int count) {
        if (count <= 0) return null;
        TreeNode node = new TreeNode(0);
        int l = (count-1)/2, r = count - l - 1;
        node.left = constructTree(l);
        node.right = constructTree(r);
        return node;
    }
    public void setTree(TreeNode root) {
        if (root.left != null) setTree(root.left);
        root.val = p.val;
        p = p.next;
        if (root.right != null) setTree(root.right);
    }
}
