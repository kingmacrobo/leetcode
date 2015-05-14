/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // the strategy is merge sort
 // using the mergeTwo method to merge two list a time, and recurse it.
 // time is O(kn), where k is the counts of lists and n is the average length of one list.
 // space is O(kn), since it needs maximum kn nodes to store the temporary result;
 
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> result = new ArrayList<ListNode>();
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        for (int i = 0 ; i < lists.length; i += 2) {
            if (i+1 < lists.length) {
                result.add(mergeTwo(lists[i],lists[i+1]));
            }
        }
        if (lists.length % 2 != 0)
            result.add(lists[lists.length-1]);
        return mergeKLists((ListNode[])result.toArray(new ListNode[0]));
    }
    public ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode result = a, pre = a;
        if (a == null) return b;
        if (b == null) return a;
        if (a.val > b.val) {
            result = b;
            pre = b;
            b = b.next;
        }
        else a = a.next;
        while(a != null || b != null) {
            if (a != null && (b == null || a.val < b.val)) {
                pre.next = a;
                pre = a;
                a = a.next;
            }
            else {
                pre.next = b;
                pre = b;
                b = b.next;
            }
        }
        return result;
    }
}
