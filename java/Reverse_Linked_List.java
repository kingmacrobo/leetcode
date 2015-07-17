// Iteratively
// Time O(n), space O(1).

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, p = head;
        while (p != null) {
            head = p.next;
            p.next = pre;
            pre = p;
            p = head;
        }
        return pre;
    }
}
