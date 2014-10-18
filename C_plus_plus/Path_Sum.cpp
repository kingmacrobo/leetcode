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
    bool hasPathSum(TreeNode *root, int sum) {
        if(!root) return false;
        return dsp(root,0,sum);
    }
    bool dsp(TreeNode *node , int pre , int sum){
        if(node->left==NULL&&node->right==NULL&&pre+node->val==sum) 
            return true;
        bool a = false,b = false;
        if(node->left) a = dsp(node->left,pre+node->val,sum);
        if(node->right) b = dsp(node->right,pre+node->val,sum);
        return a||b;
    }
};
