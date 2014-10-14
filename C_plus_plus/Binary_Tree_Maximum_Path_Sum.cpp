class Solution {
public:
    int max;
    int maxPathSum(TreeNode *root) {
        max = root->val;
        int temp = dp(root);
        return max>temp?max:temp;
    }
    int dp(TreeNode * node){
        if(node == NULL) return 0;
        int a = dp(node->left);
        int b = dp(node->right);
        int temp = a>b?a:b;
        if(a+b+node->val>max) max = a+b+node->val;
        if(node->val<0&&temp>max) max = temp;
        if(temp<=0) return node->val;
        else return node->val+temp;
    }
};
