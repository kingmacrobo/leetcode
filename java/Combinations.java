// Backtracking method
// Time and space both are O(C(n,k)).

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> temp = new LinkedList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n) return result;
        for (int i = 1; i <= n; ++i)
            list.add(i);
        deal(result,list,temp,k,0);
        return result;
    }
    void deal (List<List<Integer>> result, List<Integer> list, LinkedList<Integer> temp, int k, int start) {
        if (k == 0) {
            result.add((LinkedList)temp.clone());
            return;
        }
        for (int i = start; i < list.size(); ++i) {
            int val = list.get(i);
            temp.add(val);
            deal(result,list,temp,k-1,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
