// Copy the val among nodes.
// Time is O(n), space is O(1).

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode after = node.next;
        while (after != null) {
            node.val = after.val;;
            if (after.next == null) node.next = null;
            node = after;
            after = after.next;
        }
    }
}
