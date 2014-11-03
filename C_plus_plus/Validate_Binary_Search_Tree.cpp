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
    bool isValidBST(TreeNode *root) {
        return isBST(root,INT_MIN,INT_MAX);
    }
    bool isBST(TreeNode *root , int min , int max){
        if(!root) return true;
        if(root->val>=max||root->val<=min) return false;
        if(isBST(root->left,min,root->val)&&isBST(root->right,root->val,max))
            return true;
        return false;
    }
};
