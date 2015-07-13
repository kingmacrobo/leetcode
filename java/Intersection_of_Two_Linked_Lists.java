// Fisrt we should revser the list A, head linked A with B's head, which make the two list to a cycle list.
// So, the problem is the same as Get the Begin node of a cycle list.
// Finally, we recover the two lists and return the cross node!
// Time is O(n), space is O(1).

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tail = reverse(headA);
        headA.next = headB;
        ListNode result = getBeginNode(tail);
        headA.next = null;
        reverse(tail);
        return result;
        
    }
    public ListNode getBeginNode(ListNode head) {
        ListNode fast = head, slow = head, cross = null;
        boolean first = true;
        while (fast != null && slow != null) {
            if (fast == slow && !first) {
                cross = fast;
                break;
            }
            first = false;
            if (fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (cross == null) return null;
        while (true) {
            if (head == cross) break;
            head = head.next;
            cross = cross.next;
        }
        return head;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null, p = head, result = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            if (tmp == null) result = p;
            p = tmp;
        }
        return result;
    }
}
