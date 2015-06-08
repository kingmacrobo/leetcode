// Just record the small head & tail and big head and tail
// One pass
// Time is O(n), space is O(1).

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sHead = null, sPre = null, bHead = null, bPre = null, p = head;
        while (p != null) {
            if (p.val < x) {
                if (sHead == null)
                    sHead = p;
                else 
                    sPre.next = p;
                sPre = p;
            }
            else {
                if (bHead == null)
                    bHead = p;
                else
                    bPre.next = p;
                bPre = p;
            }
            p = p.next;
        }
        if (bPre != null) bPre.next = null;
        if (sHead != null)
            sPre.next = bHead;
        return sHead == null ? bHead : sHead;
    }
}
