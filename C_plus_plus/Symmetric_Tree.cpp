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
    bool isSymmetric(TreeNode *root) {
        if(!root) return true;
        return recursive(root->left,root->right);
    }
    bool recursive(TreeNode *left,TreeNode *right){
        if(!left&&!right) return true;
        if(!left||!right||left->val!=right->val) return false;
        return recursive(left->left,right->right)&&recursive(left->right,right->left);
    }
};
