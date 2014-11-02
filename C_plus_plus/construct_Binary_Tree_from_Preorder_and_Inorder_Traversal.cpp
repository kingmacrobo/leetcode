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
    int current;
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        current = 0;
        unordered_map<int,int> hash;
        for(int i = 0 ; i < inorder.size(); ++i)
            hash.insert({inorder[i],i});
        return createTree(hash,inorder,0,inorder.size()-1,preorder);
    }
    TreeNode *createTree(unordered_map<int,int> &hash,vector<int> &inorder,int start,int end, vector<int> &preorder){
        if(start>end) return NULL;
        int k = hash.find(preorder[current])->second;
        ++current;
        TreeNode * p = new TreeNode(inorder[k]);
        p->left = createTree(hash,inorder,start,k-1,preorder);
        p->right = createTree(hash,inorder,k+1,end,preorder);
        return p;
    }
};
