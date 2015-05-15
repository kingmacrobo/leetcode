/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // one pass
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next == null) return head;
        ListNode p = head, pre = null;
        head = head.next;
        while(p != null && p.next != null) {
            ListNode after = p.next;
            p.next = after.next;
            after.next = p;
            if (pre!=null)
                pre.next = after;
            pre = p;
            p = p.next;
        }
        return head;
    }
}
