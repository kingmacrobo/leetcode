/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode *p = head,*last = head;
        while(p){
            if(p->val != last->val){
                last->next = p;
                last = p;
            }
            p = p->next;
        }
        if(last) last->next = NULL;
        return head;
    }
};
