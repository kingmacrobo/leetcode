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
    ListNode *swapPairs(ListNode *head) {
        ListNode *result = head,*left,*right,*last=NULL;
        while(head&&head->next){
            left = head;
            right = head->next;
            head = head->next->next;
            left->next = right->next;
            right->next = left;
            if(!last){
                result = right;
                last = left;
            }
            else{
                last->next = right;
                last = left;
            }
        }
        return result;
    }
};
