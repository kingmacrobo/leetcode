// BFS queue
// Time is O(n), space is O(n).

public class Solution {
    public int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if (root !=null) que.offer(root);
        while (que.peek() != null) {
            depth++;
            for (int n = que.size(); n > 0 ; --n) {
                TreeNode node = que.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return depth;
    }
}
