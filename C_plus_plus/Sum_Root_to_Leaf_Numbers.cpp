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
    int sum;
    int sumNumbers(TreeNode *root) {
        sum = 0;
        if(root == NULL) return 0;
        travel(root,0);
        return sum;
    }
    void travel(TreeNode *node,int pre){
        if(node->left == NULL && node->right == NULL)
            sum += pre*10+node->val;
        else{
            if(node->left != NULL) travel(node->left,pre*10+node->val);
            if(node->right != NULL) travel(node->right,pre*10+node->val);
        }
    }
};
