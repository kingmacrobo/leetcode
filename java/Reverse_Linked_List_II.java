// First, locate the m node, and then reverse the n-m+1 nodes, 
// in which process we should record the previous last one of unreversed nodes
// and the after first one of unreversed nodes.
// And then , recombination the three parts.
// One pass, time is O(n), space is O(1).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode pre = null, after = null, p = head, last = null, tail = null;
        while(p != null) {
            if (++count == m)
                break;
            pre = p;
            p = p.next;
        }
        for (int i = 0; i < n-m+1; ++i) {
            ListNode temp = p.next;
            if (last == null) {
                tail = last = p;
            }
            else {
                p.next = last;
                last = p;
            }
            p = temp;
        }
        if (pre == null) head = last;
        else pre.next = last;
        tail.next = p;
        return head;
    }
}
