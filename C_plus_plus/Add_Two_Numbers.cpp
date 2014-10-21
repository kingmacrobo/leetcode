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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *head = NULL,*p;
        int carry = 0;
        while(l1&&l2){
            if(!head){
                head = new ListNode((l1->val+l2->val+carry)%10);
                carry = (l1->val+l2->val+carry)/10;
                head->next=NULL;
                p = head;
            }
            else{
                p->next = new ListNode((l1->val+l2->val+carry)%10);
                carry = (l1->val+l2->val+carry)/10;
                p = p->next;
                p->next = NULL;
            }
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1){
            p->next = new ListNode((l1->val+carry)%10);
            carry = (l1->val+carry)/10;
            p = p->next;
            p->next = NULL; 
            l1 = l1->next;
        }
        while(l2){
            p->next = new ListNode((l2->val+carry)%10);
            carry = (l2->val+carry)/10;
            p = p->next;
            p->next = NULL; 
            l2 = l2->next;
        }
        if(carry){
            p->next = new ListNode(carry);
            p->next->next = NULL;
        }
        return head;
    }
};
