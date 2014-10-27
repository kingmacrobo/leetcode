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
    bool isBalanced(TreeNode *root) {
        return dp(root).first;
    }
    pair<bool,int> dp(TreeNode *root){
        if(!root) return make_pair(true,0);
        pair<bool,int> a,b;
        a = dp(root->left);
        b = dp(root->right);
        if(!a.first||!b.first) return make_pair(false,0);
        if(abs(a.second-b.second)>1)
            return make_pair(false,0);
        return make_pair(true,(a.second>b.second?a.second:b.second)+1);
    }
};
