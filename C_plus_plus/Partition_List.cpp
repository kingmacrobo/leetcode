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
    ListNode *partition(ListNode *head, int x) {
        ListNode *less = NULL,*greater = NULL,*lessLast = NULL,*greaterLast = NULL , *p = head;
        while(p){
            if(p->val < x){
                if(!less)
                    less = p;
                else
                    lessLast->next = p;
                lessLast = p;
            }
            else{
                if(!greaterLast)
                    greater = p;
                else
                    greaterLast->next = p;
                greaterLast = p;
            }
            p = p->next;
        }
        if(less){
            lessLast->next = greater;
            head = less;
        }
        if(greater){
            greaterLast->next = NULL;
            if(!less)
                head = greater;
        }
        return head;
    }
};
