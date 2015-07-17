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

// Recursively
// Time is O(n), space is O(n).

public class Solution {
    ListNode result = null;
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        reverse(head).next = null;
        return result;
    }
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            result = head;
            return head;
        }
        ListNode after = reverse(head.next);
        after.next = head;
        return head;
    }
}
