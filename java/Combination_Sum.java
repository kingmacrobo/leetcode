// DFS
// Firstly, sort the candidates in the none descending order
// Then, start from the first number to search via DFS and backtracking!
// The worst time is O(target^n), where n is the count of numbers.
// Space is the result's size.

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return deal(candidates,0,target);
    }
    public List<List<Integer>> deal(int[] candidates, int pos, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();;
        if (target == 0) {
             result.add(new ArrayList<Integer>());
             return result;
        }
        if (pos >= candidates.length || candidates[pos] > target) return result;
        int count = 0;
        while (target >= 0) {
            List<List<Integer>> temp = deal(candidates, pos+1,target);
            for (int i = 0 ; i < temp.size() ; ++i) {
                List<Integer> l = temp.get(i);
                for (int j = 0 ; j < count ; ++j)
                    l.add(0,candidates[pos]);
                result.add(l);
            }
            count++;
            target -= candidates[pos];           
        }
        return result;
    }
}
