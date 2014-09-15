#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


struct RandomListNode {
    int label;
    RandomListNode *next, *random;
    RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
};

class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode * nhead = NULL,*p = NULL,*t = NULL;
        unordered_map<RandomListNode*,int> addressToPosition;
        unordered_map<int,RandomListNode*> positionToAddress;
        int position = 1,oposition = 1;
        p = head;
        while(p)
        {
            if(nhead == NULL)
            {
                nhead = new RandomListNode(p->label);
                nhead->label = p->label;
                t = nhead;
                t->next = NULL;
                positionToAddress.insert({position,t});
                ++position;
            }
            else
            {
                t->next = new RandomListNode(p->label);
                t = t->next;
                t->label = p->label;
                t->next = NULL;
                positionToAddress.insert({position,t});
                ++position;
            }
            addressToPosition.insert({p,oposition});
            ++oposition;
            p = p->next;
        }
        
        p = head;
        t = nhead;
        unordered_map<RandomListNode*,int>::iterator got;
        unordered_map<int,RandomListNode*>::iterator set;
        while(p)
        {
            if(p->random==NULL)
                t->random = NULL;
            else
            {
                got = addressToPosition.find(p->random);
                set = positionToAddress.find(got->second);
                t->random = set->second;
            }
            p = p->next;
            t = t->next;
        }
        
        return nhead;
    }
};

int main()
{
    Solution st;
    RandomListNode a(1),b(2),c(3),d(4),e(5),*re;
    a.next = &b;
    b.next = &c;
    c.next = &d;
    d.next = &e;
    e.next = NULL;
    
    a.random = &c;
    b.random = &d;
    c.random = NULL;
    d.random = &a;
    e.random = &b;
    
    re = st.copyRandomList(&a);
    return 0;
}