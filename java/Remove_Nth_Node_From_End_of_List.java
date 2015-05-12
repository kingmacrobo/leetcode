/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // fast and low pointer method
 // one pass
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, low = head, before = head;
        while (n-- > 1) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            before = low;
            low = low.next;
        }
        if (low == head)
            return low.next;
        else {
            before.next = low.next;
            return head;
        }
    }
}
