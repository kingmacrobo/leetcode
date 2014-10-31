/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode *root) {
        queue<pair<TreeNode *,int>> que;
        if(!root) return 0;
        que.push(make_pair(root,1));
        while(!que.empty()){
            pair<TreeNode *,int> p = que.front();
            que.pop();
            if(!p.first->left&&!p.first->right) 
                return p.second;
            if(p.first->left) que.push(make_pair(p.first->left,p.second+1));
            if(p.first->right) que.push(make_pair(p.first->right,p.second+1));
        }
    }
};
