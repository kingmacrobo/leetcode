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

// DFS recursive
// Time and space are both O(n).

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
