class Solution {
public:
    void connect(TreeLinkNode *root) {
        TreeLinkNode  *cur, *last,*start=NULL;
        start = root;
        while(start){
            cur = start;
            start = last = NULL;
            while(cur){
                if(cur->left&&cur->right) {
                    if(!start) start = cur->left;
                    cur->left->next = cur->right;
                    if(last) last->next = cur->left;
                    last = cur->right;
                }
                else if (!cur->left && !cur->right){
                    cur = cur->next;
                    continue;
                } 
                else if (cur->left) {
                    if(!start) start = cur->left;
                    if(last) last->next = cur->left;
                    last = cur->left;
                }
                else {
                    if(!start) start = cur->right;
                    if(last) last->next = cur->right;
                    last = cur->right;
                }
                cur = cur->next;
            }
        }
    }
};
