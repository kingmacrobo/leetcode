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
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        queue<pair<TreeNode *,int>> que;
        bool lr = true;
        int level = 1;
        vector<vector<int> > result;
        vector<int> tmp;
        que.push(make_pair(root,1));
        while(!que.empty()){
            pair<TreeNode *,int> p = que.front();
            que.pop();
            if(!p.first) continue;
            if(p.second>level){
                if(lr)  result.push_back(tmp);
                else {
                    reverse(tmp.begin(),tmp.end());
                    result.push_back(tmp);
                }
                lr = !lr;
                tmp.clear();
                ++level;
            }
            tmp.push_back(p.first->val);
            que.push(make_pair(p.first->left,p.second+1));
            que.push(make_pair(p.first->right,p.second+1));
        }
        if(tmp.size()){
            if(lr)  result.push_back(tmp);
            else {
                reverse(tmp.begin(),tmp.end());
                result.push_back(tmp);
            }           
        }
        return result;
    }
};
