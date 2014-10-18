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
    vector<vector<int>> result;
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        if(!root) return result;
        dsp(root,vector<int>(),0,sum);
        return result;
    }
    void dsp(TreeNode *node , vector<int> prev , int pre , int sum){
        if(node->left==NULL&&node->right==NULL&&pre+node->val==sum) {
            prev.push_back(node->val);
            result.push_back(prev);
            return;
        }
        prev.push_back(node->val);
        if(node->left) dsp(node->left,prev,pre+node->val,sum);
        if(node->right) dsp(node->right,prev,pre+node->val,sum);
    }
};
