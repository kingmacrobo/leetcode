/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // pass the list twice
 // the fisrt time count the list nodes, and find out how many segments we should reverse
 // int the second pass, we reverse each segments
 // you should be careful with the remain nodes when the count list nodes is not multiple of k.
 // so, time is O(n), space is O(1)
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = null, p = head, pre = null, pretail = null;
        boolean dealhead =false;
        int count = 0;
        int total = 0;
        while (p!=null) {
            total++;
            p = p.next;
        }
        int segs = total/k;
        int num = 1;
        p = head;
        while (p != null && num <=segs) {
            count++;
            if (count == 1) tail = p;
            if (count == k) {
                if (!dealhead) {
                    dealhead = true;
                    head = p;
                }
                if (pretail != null)
                    pretail.next = p;
                pretail = tail;
                count = 0;
                num++;
            }
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        if (pretail != null)
            pretail.next = p;
        return head;
    }
}
