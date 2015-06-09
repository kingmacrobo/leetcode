// recursive solution
// take each node as the root, and recursive the two side

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    public List<TreeNode> generate(int a, int b) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (a > b) {
            result.add(null);
            return result;
        }
        if (a == b) {
            result.add(new TreeNode(a));
            return result;
        }
        for (int i = a; i <= b; ++i) {
            List<TreeNode> left = generate(a,i-1);
            List<TreeNode> right = generate(i+1,b);
            for (int j = 0; j < left.size(); ++j)
                for (int k = 0; k< right.size(); ++k) {
                    TreeNode node = new TreeNode(i);
                    node.left = left.get(j);
                    node.right = right.get(k);
                    result.add(node);
                }
        }
        return result;
    }
}
