// DFS
// Just one line code !
// Time is O(n), space is O(n);
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

// BFS
// Time is O(n), space is O(n).
public class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int depth = 0;
        while (que.peek() != null) {
            depth++;
            for (int n = que.size(); n > 0 ; n--) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return depth;
    }
}
