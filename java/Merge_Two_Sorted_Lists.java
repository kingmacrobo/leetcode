/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // time is O(n)
 // the special dealing:  if (l2 == null || l1 !=null && l1.val < l2.val)
 // which makes the code more simple!
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = l1, last = l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l2.val < l1.val) {
            last = result = l2;
            l2 = l2.next;
        }
        else l1 = l1.next;
        while(l1 != null || l2 !=null) {
            if (l2 == null || l1 !=null && l1.val < l2.val) {
                last.next = l1;
                last = l1;
                l1 = l1.next;
            }
            else {
                last.next = l2;
                last = l2;
                l2 = l2.next;
            }
        }
        return result;
    }
}
