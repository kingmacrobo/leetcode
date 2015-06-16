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
