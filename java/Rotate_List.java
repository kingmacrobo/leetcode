// Firstly, count the List length.
// If the K is greater than list's length, there will be many circulations, so we can use mod to calculate the final index.
// k = k mod len, the new k means the kth node from the list end.
// So the problem turn to be the last kth node of a linked list problem
// We can solve it by two points : fast and low.
// Time is O(n), space is O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        if (count == 0) return head;
        k = k % count;
        if (k == 0) return head;
        ListNode fast = head, low = head, ret = null;
        for (int i = 0; i < k; ++i)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        ret = low.next;
        low.next = null;
        fast.next = head;
        return ret;
    }
}
