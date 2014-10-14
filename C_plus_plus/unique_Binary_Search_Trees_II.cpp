class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        return create(1,n);
    }
    vector<TreeNode *> create(int start, int end){
        vector<TreeNode *> result;
        if(start>end) return vector<TreeNode *>(1);
        if(start==end)
            return vector<TreeNode *>(1,new TreeNode(start));
        for(int i = start ; i <= end ; ++i){
            vector<TreeNode *> left,right;
            left = create(start,i-1);
            right = create(i+1,end);
            for(int j = 0 ; j < left.size() ; ++j)
                for(int w = 0 ; w < right.size(); ++w){
                    TreeNode *tmp = new TreeNode(i);
                    tmp->left = left[j];
                    tmp->right = right[w];
                    result.push_back(tmp);
                }
        }
        return result;
    }
};
