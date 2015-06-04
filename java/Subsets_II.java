// Iteration solution
// All things are same as subsets problem, expect for duplicated numbers.
// The way to deal with duplicated numbers is that :
//    Suppose that we should deal with k continuous numbers a, we can use the method below to generate the current result :
//    we add one a to previous result, add 2 a to previous result, add 3 a , .... add k a.
// The above method can prevent the duplicated list being generated.
// Time and space are both O(2^n)

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            int size = result.size();
            int count = 1;
            while (i+1 < nums.length && nums[i+1] == nums[i]) {
                i++;
                count++;
            }
            for (int j = 0; j < size; ++j) {
                for (int k = 1; k <= count; ++k) {
                    List<Integer> list = new ArrayList<Integer>(result.get(j));
                    for (int w = 0; w < k; ++w)
                        list.add(nums[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
