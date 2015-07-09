// Insertion sort by linked list.
// Time is O(n^2), no extra space !

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = null, p = null, tail = null;
        while (head != null) {
            ListNode temp = head.next;
            if (result == null) {
                result = head;
                result.next = null;
            }
            else {
                p = result;
                while (p != null && head.val > p.val) {
                    tail = p;
                    p = p.next;
                }
                if (p == null) {
                    tail.next = head;
                    head.next = null;
                }
                else if (p == result) {
                    head.next = result;
                    result = head;
                }
                else {
                    tail.next = head;
                    head.next = p;
                }
            }
            head = temp;
        }
        return result;
    }
}
