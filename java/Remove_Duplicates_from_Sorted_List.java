// Record the pre node, and compare the current node with pre, if the vals are equal, continue, or update the pre.
// One pass.
// Time is O(n), space is O(1).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, p = head;
        if (head == null) return null;
        p = p.next;
        while (p != null) {
            if (p.val != pre.val) {
                pre.next = p;
                pre = p;
            }
            p = p.next;
        }
        pre.next = null;
        return head;
    }
}
