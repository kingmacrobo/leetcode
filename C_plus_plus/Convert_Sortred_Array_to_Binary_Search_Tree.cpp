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
    TreeNode *sortedArrayToBST(vector<int> &num) {
        int end = num.size();
        return createBST(num,0,end-1);
    }
    TreeNode *createBST(vector<int> &num,int start , int end){
        if(start>end) return NULL;
        TreeNode *p = new TreeNode(num[(start+end)/2]);
        p->left = createBST(num,start,(start+end)/2-1);
        p->right = createBST(num,(start+end)/2+1,end);
        return p;
    }
};
