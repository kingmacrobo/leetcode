// Linked list operation
// Delete list element method
// Time is O(n), space is O(1).

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null, p = head;
        while (p != null) {
            if (p.val == val) {
                if (p == head) {
                    head = p.next;
                }
                else pre.next = p.next;
            }
            else {
                pre = p;
            }
            p = p.next;
        }
        return head;
    }
}
