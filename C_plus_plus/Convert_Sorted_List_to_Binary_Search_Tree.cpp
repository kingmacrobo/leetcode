/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode *sortedListToBST(ListNode *head) {
        vector<TreeNode*> hash;
        int i = 0;
        while(head){
            hash.push_back(new TreeNode(head->val));
            head = head->next;
            ++i;
        }
        return createBST(hash,0,i-1);
    }
    TreeNode *createBST(vector<TreeNode*> &hash,int start,int end){
        if(start>end) return NULL;
        int k = (start+end)/2;
        hash[k]->left = createBST(hash,start,k-1);
        hash[k]->right = createBST(hash,k+1,end);
        return hash[k];
    }
};
