// First find the cross node on the cycle by fast and slow method.
// And then, we can prove that, a = kq + c, which means one pointer starts from the begin,
// and the other pointer start from the cross node, and they step one node once, finally, they
// will cross in one node, which is the start node of the cycle.

// if we regard the list as there parts : a -> b - > c -> b, where a,b,c presents a sequence nodes of the list, the prove can be that :
// fast pointer pass two nodes and slow pointer pass one node, and they cross on the linked , dividing the cycle into part b and c.
// so, 
//              2(a + b) = a + b + kq,     where q is the length of the cycle and k is the times of the cycle.
// we can simplized it like this :
//              a = kq - b, 
// more simplized, we make it like this :
//              a = k'q + c
// now, we can see that, the length of a is the length of c plusing the times of the cycle,
// which, in the graph , represents the tip that if we start from cross node and begin node in the meantime, they will across together!
// So, we prove it!

// Time is O(n), space is O(1).

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, cross = null;
        int count = 0;
        while (fast != null && slow != null) {
            if (fast == slow) {
                count ++;
                if (count == 2) {
                    cross = fast;
                    break;
                }
            }
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }
        if (cross == null) return null;
        while (cross != head) {
            cross = cross.next;
            head = head.next;
        }
        return cross;
    }
}
