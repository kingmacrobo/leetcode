// First, count the list
// then divid the list into two parts, which contains the same nodes (odd case will be one more node in the previous list).
// And then reverse the second list.
// Finally merge the two list one node by one node.
// Time is O(n), space is O(1).

public class Solution {
    public void reorderList(ListNode head) {
        int count = 0, half = 0;
        ListNode p = head, revers = null, q = null, pre = null;;
        while (p != null) {
            count ++;
            p = p.next;
        }
        if (count <= 1) return;
        p = head;
        while (p != null) {
            half++;
            if (half == count/2)
                break;
            p = p.next;
        }
        if (count % 2 == 1)
            p = p.next;
        revers = p.next;
        p.next = null;
        q = revers;
        while (q != null) {
            revers = q;
            ListNode temp = q.next;
            q.next = pre;
            pre = q;
            q = temp;
        }
        p = head;
        q = revers;
        while (p != null && q != null) {
            ListNode temp = p.next, temp2 = q.next;;
            p.next = q;
            q.next = temp;
            p = temp;
            q = temp2;
        }
    }
}
