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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        vector<ListNode*> hash;
        ListNode *p = head;
        int i = 0;
        while(p){
            hash.push_back(p);
            p = p->next;
            ++i;
        }
        if(n==i) head = head->next;
        else
            hash[i-n-1]->next = hash[i-n]->next;
        return head;
    }
};
