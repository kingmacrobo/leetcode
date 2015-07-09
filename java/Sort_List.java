// Merge Sort of Linked List
// Time is O(nlogn), space is O(1).

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode fast = head , slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return merge(sortList(head),sortList(second));
    }
    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = null, pre = null;
        while (a != null || b != null) {
            if (a == null) {
                if (head == null) return b;
                pre.next = b;
                return head;
            }
            if (b == null) {
                if (head == null) return a;
                pre.next = a;
                return head;
            }
            if (a.val <= b.val) {
                if (head == null) {
                    pre = head = a;
                }
                else {
                    pre.next = a;
                    pre = a;
                }
                a = a.next;
            }
            else {
                if (head == null) {
                    pre = head = b;
                }
                else {
                    pre.next = b;
                    pre = b;
                }
                b = b.next;
            }
        }
        return head;
    }
}
