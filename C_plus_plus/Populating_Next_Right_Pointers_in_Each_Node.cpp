/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        queue<TreeLinkNode *> que;
        int i = 0,k = 2;
        que.push(root);
        while(!que.empty()){
            TreeLinkNode * p = que.front();
            que.pop();
            if(!p) return;
            if(++i == k-1){
                p->next = NULL;
                k *= 2;
            }
            else p->next = que.front();
            que.push(p->left);
            que.push(p->right);
        }
    }
};
