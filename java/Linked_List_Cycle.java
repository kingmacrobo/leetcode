// Fast and slow pointer!
// Time is o(n), space is O(1).

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null && slow != null) {
            if (fast == slow) count++;
            if (count == 2) return true;
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
        }
        return false;
    }
}
