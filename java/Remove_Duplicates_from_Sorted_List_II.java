// Using count to record the continuous val, and remove it if count > 1
// One pass 
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
        ListNode pre = null, p = head;
        while (p != null) {
            int count = 1;
            while(p.next != null && p.val == p.next.val) {
                count++;
                p = p.next;
            }
            if (count == 1) {
                if (pre == null) {
                    pre = head = p;
                }
                else {
                    pre.next = p;
                    pre = p;
                }
            }
            p = p.next;
        }
        if (pre == null) return null;
        pre.next = null;
        return head;
    }
}
