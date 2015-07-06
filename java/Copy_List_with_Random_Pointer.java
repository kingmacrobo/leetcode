// Hash solution
// First pass to create the hash table and linked list;
// Second pass to linked the random pointer to the cerrosponding pointer via hash table.
// Time is O(n), space is O(n);

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> table = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode first = null, p = head, fp = null;
        while (p != null) {
            if (p == head) {
                fp = first = new RandomListNode(p.label);
            }
            else {
                fp.next = new RandomListNode(p.label);
                fp = fp.next;
            }
            table.put(p,fp);
            p = p.next;
        }
        p = head;
        fp = first;
        while (p != null) {
            fp.random = table.get(p.random);
            p = p.next;
            fp = fp.next;
        }
        return first;
    }
}
