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
        ListNode *last = NULL,*result = NULL;
        if(!head||!(head->next)) return head;
        while(head){
            int isDul = false;
            while(head&&head->next&&head->val==head->next->val){ 
                head = head->next;
                isDul = true;
            }
            if(!isDul){
                if(last){
                    last->next = head;
                    last = head;
                }
                else
                    last = result = head;
            }
            head = head->next;
        }
        if(last) last->next = NULL;
        return result;
    }
};
