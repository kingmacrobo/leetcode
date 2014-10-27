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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode *head=NULL,*last=NULL;
        if(!l1) return l2;
        if(!l2) return l1;
        while(l1&&l2){
            if(l1->val<l2->val){
                if(!head) {
                    last = head = l1;
                    l1 = l1->next;
                }
                else{
                    last->next = l1;
                    last = l1;
                    l1 = l1->next;
                }
            }
            else{
                if(!head) {
                    last = head = l2;
                    l2 = l2->next;
                }
                else{
                    last->next = l2;
                    last = l2;
                    l2 = l2->next;
                }
            }
        }
        if(l1) last->next = l1;
        else if(l2) last->next = l2;
        return head;
    }
};
