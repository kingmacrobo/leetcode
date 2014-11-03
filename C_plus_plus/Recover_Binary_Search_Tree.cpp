class Solution {
public:
    void recoverTree(TreeNode *root) {
        vector<TreeNode *> mistake;
        findMistake(mistake,root,INT_MIN,INT_MAX,NULL,NULL);
        for(int i = 0 ; i < mistake.size() ; ++i){
            for(int j = i+1; j < mistake.size(); ++j){
                int tt = mistake[i]->val;
                mistake[i]->val = mistake[j]->val;
                mistake[j]->val = tt;
                if(isBST(root,INT_MIN,INT_MAX)) return;
                tt = mistake[i]->val;
                mistake[i]->val = mistake[j]->val;
                mistake[j]->val = tt;
            }
        }
    }
    void findMistake(vector<TreeNode *> &mistake,TreeNode *root,int min, int max, TreeNode *minNode,TreeNode *maxNode){
        if(!root) return;
        if(root->val>=max||root->val<=min){
            mistake.push_back(root);
            if(maxNode&&root->val>=max) mistake.push_back(maxNode);
            if(minNode&&root->val<=min) mistake.push_back(minNode);
        }
        findMistake(mistake,root->left,min,root->val,minNode,root);
        findMistake(mistake,root->right,root->val,max,root,maxNode);
    }
    bool isBST(TreeNode *root , int min , int max){
        if(!root) return true;
        if(root->val>=max||root->val<=min) return false;
        if(isBST(root->left,min,root->val)&&isBST(root->right,root->val,max))
            return true;
        return false;
    }
};
