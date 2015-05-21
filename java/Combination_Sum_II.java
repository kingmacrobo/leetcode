// DFS,Backtracking
// Be caresul with the duplicate result.

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        dfs(candidates,0,target,result,l);
        return result;
    }
    public void dfs(int[] candidates, int pos, int target, List<List<Integer>> result, ArrayList<Integer> l) {
        if (target == 0) {
            result.add((ArrayList<Integer>)l.clone());
            return;
        }
        if (pos >= candidates.length || candidates[pos] > target) return;
        int count = 1;
        while (pos+1 < candidates.length && candidates[pos+1] == candidates[pos]){
            count++;
            pos++;
        }
        for (int i = 0; i <= count && target >= candidates[pos]*i ; ++i) {
            for (int j = 0 ; j < i; ++j)
                l.add(candidates[pos]);
            dfs(candidates,pos+1,target - candidates[pos]*i,result,l);
            for (int j = 0; j < i; ++j)
                l.remove(l.size()-1);
        }
    }
}
