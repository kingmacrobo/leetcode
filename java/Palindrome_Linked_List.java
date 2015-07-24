// Travel at the middle of the list, and reverse the previous, then compare with the suffix.
// Time is O(n), space is O(1).

public class Solution {
    public boolean isPalindrome(ListNode head) {
        int count = 0, cur = 0;
        ListNode p = head, after = null;
        while (p != null) {
            p = p.next;
            count++;
        }
        if (count <= 1) return true;
        p = head;
        while (p != null) {
            if (++cur == count/2) break;
            p = p.next;
        }
        after = p.next;
        p.next = null;
        if (count%2 == 1) after = after.next;
        p = reverse(head);
        while (p != null) {
            if (p.val != after.val) return false;
            p = p.next;
            after = after.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null, p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }
}
