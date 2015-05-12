// first sort the array
// then, find the answer using two point strategy
// time is O(n^2), space is O(n)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; ++i) {
            int a = nums[i];
            if (i-1 >= 0 && a == nums[i-1]) continue;
            for (int j = i+1 ; j < nums.length ; ++j) {
                int b = nums[j] ;
                if (j-1 > i && b == nums[j-1]) continue;
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int value = a+b+nums[low]+nums[high];
                    if (value == target) {
                        result.add(Arrays.asList(a,b,nums[low],nums[high]));
                        while(++low < high && nums[low] == nums[low-1]) ;
                        while(low < --high && nums[high] == nums[high+1]) ;
                    }
                    else if (value > target) --high;
                    else ++low;
                }
            }
        }
        return result;
    }
}
