// Method 1
// Using zigzag flag to represent the normal sequence or the reverse sequence
// Using cur, curCount and nextCount to record the level switch event, and handle the list in the level.
// Time is O(n), space is O(n).

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        boolean zigzag = false;
        int nextCount = 0, curCount = 1, cur = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        que.offer(root);
        while (que.peek() != null) {
            TreeNode node = que.poll();
            if (zigzag)
                list.add(0,node.val);
            else
                list.add(node.val);
            if (node.left != null ) {
                que.offer(node.left);
                nextCount++;
            }
            if (node.right != null) {
                que.offer(node.right);
                nextCount++;
            }
            if (++cur == curCount) {
                result.add(list);
                list = new ArrayList<Integer>();
                zigzag = !zigzag;
                curCount = nextCount;
                nextCount = 0;
                cur = 0;
            }

        }
        return result;
    }
}

// Method 2
// The difference with method 1 is that we use a extra queue to record each element's level info,
// so that it seems more concise when switch and handle levels, which, on the other side, costs more space.
// Time is O(n), space is O(n).

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        boolean zigzag = false;
        int nextLev = 2;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        que.offer(root);
        level.offer(1);
        while (que.peek() != null) {
            int lev = level.poll();
            TreeNode node = que.poll();
            if (lev == nextLev) {
                result.add(list);
                list = new ArrayList<Integer>();
                nextLev++;
                zigzag = !zigzag;
            }
            if (node.left != null ) {
                que.offer(node.left);
                level.offer(lev+1);
            }
            if (node.right != null) {
                que.offer(node.right);
                level.offer(lev+1);
            }
            if (zigzag)
                list.add(0,node.val);
            else
                list.add(node.val);
        }
        if (list.size() != 0)
            result.add(list);
        return result;
    }
}
