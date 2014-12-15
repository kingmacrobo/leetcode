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
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        ListNode *p = head,*last = NULL,*begin = NULL,*end = NULL,*before = NULL,*a = NULL,*b=NULL;
        int pos = 1;
        bool reverseFlag = false;
        while(p){
            if(pos == m){
                begin = last;
                a = p;
                reverseFlag = true;
            }
            if(pos == n){
                end = p->next;
                b = p;
                p->next = before;
                break;
            }
            if(reverseFlag){
                ListNode * temp = p;
                p = p->next;
                temp->next = before;
                before = temp;
            }
            else{
                last = p;
                p = p->next;
            }
            ++pos;
        }
        if(begin)
            begin->next = b;
        if(a)
            a->next = end;
        if(m==1) return b;
        else return head;
    }
};
