// first sort the array,
// then, find the answer using two point strategy.
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; ++i) {
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
					int a = Math.abs(nums[i] + nums[low] + nums[high] - target);
					if (a == 0) return target;
					if (a < Math.abs(result - target)) 
					    result = nums[i] + nums[low] + nums[high];
					if (nums[i] + nums[low] + nums[high] > target) 
					    --high;
					else ++low;
			}
		}
		return result;
	}
}
