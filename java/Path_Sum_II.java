// Backtracking
// Time is O(n), space is O(n).

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) return result;
        list.add(root.val);
        generate(result, list, root, sum);
        return result;
    }
    public void generate(List<List<Integer>> result, LinkedList<Integer> list, TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                result.add((LinkedList<Integer>)list.clone());
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            generate(result, list, root.left, sum - root.val);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            generate(result, list, root.right, sum - root.val);
            list.remove(list.size()-1);
        }
        return;
    }
}
