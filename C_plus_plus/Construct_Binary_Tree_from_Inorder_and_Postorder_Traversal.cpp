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
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        unordered_map<int,int> hash;
        current = postorder.size()-1;
        for(int i = 0 ; i < inorder.size(); ++i)
            hash.insert({inorder[i],i});
        return createTree(hash,inorder,0,inorder.size()-1,postorder);
    }
    TreeNode *createTree(unordered_map<int,int> &hash,vector<int> &inorder,int start,int end, vector<int> &postorder){
        if(start>end) return NULL;
        int k = hash.find(postorder[current])->second;
        --current;
        TreeNode * p = new TreeNode(inorder[k]);
        p->right = createTree(hash,inorder,k+1,end,postorder);
        p->left = createTree(hash,inorder,start,k-1,postorder);
        return p;
    }
};
