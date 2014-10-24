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
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        queue<pair<TreeNode *, int>> que;
        vector<vector<int> > result;
        vector<int> tmp;
        int level = 0;
        que.push(make_pair(root,0));
        while(!que.empty()){
            pair<TreeNode *, int> p = que.front();
            que.pop();
            if(p.first){
                if(p.second>level){
                    result.insert(result.begin(),tmp);
                    tmp.clear();
                    level = p.second;
                }
                tmp.push_back(p.first->val);
                que.push(make_pair(p.first->left,p.second+1));
                que.push(make_pair(p.first->right,p.second+1));
            }
        }
        if(tmp.size()) result.insert(result.begin(),tmp);
        return result;        
    }
};
