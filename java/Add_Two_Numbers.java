/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, p = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0){
            if (result == null) {
                result = new ListNode(0);
                p = result;
            }
            else {
                p.next = new ListNode(0);
                p = p.next;
            }
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next ;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next ;
            }
            p.val = sum % 10;
            carry = sum / 10;
        }
        return result;
    }
}
