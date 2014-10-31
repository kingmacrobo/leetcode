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
    void flatten(TreeNode *root) {
        insert(root);
    }
    TreeNode * insert(TreeNode *root){
        TreeNode *last;
        if(!root) return NULL;
        if(!root->left&&!root->right) return root;
        TreeNode * right = root->right;
        if(root->left){
            root->right = root->left;
            root->left=NULL;
            last = insert(root->right);
            if(right){
                last->right = right;
                return insert(right);
            }
            else return last;
        }
        else return insert(right);
    }
};
