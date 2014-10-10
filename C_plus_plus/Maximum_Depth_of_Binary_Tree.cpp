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
    int maxDepth(TreeNode *root) {
        int a=0,b=0;
        if(root==NULL) return 0;
        a =  maxDepth(root->left)+1;
        b =  maxDepth(root->right)+1;
        return a>b?a:b;
    }
};
