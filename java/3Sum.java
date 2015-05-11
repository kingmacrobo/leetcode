// first sort the array in O(nlogn)
// then,find all the cases by two point method in O(n^2)
// so, the solution's time complexity is O(n^2), space is O(n);
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>() ;
        Arrays.sort(nums) ;
        for (int i = 0 ; i < nums.length ; ++i) {
            if (i-1 >= 0 && nums[i] == nums[i-1]) continue;
            int target = nums[i] ;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] + target == 0) {
                    List<Integer> list = Arrays.asList(nums[i],nums[low],nums[high]);
                    result.add(list) ;
                    while (++low < high && nums[low-1] == nums[low]);
                    while (--high > low && nums[high+1] == nums[high]);
                }
                else if (nums[low] + nums[high] + target < 0) ++low;
                else --high;
            }
        }
        return result ;
    }
}
