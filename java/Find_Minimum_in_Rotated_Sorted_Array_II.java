// Binary Search
// When nums[mid] = nums[low] = nums[high], we should calculate both two parts of the subarrays.
// Worst time is O(n), best time is O(logn), space is O(1).

public class Solution {
    public int findMin(int[] nums) {
        return find(nums,0,nums.length-1);
    }
    public int find(int[] nums, int low, int high) {
        while (low < high) {
            int mid = (low+high)/2;
            if (nums[mid] == nums[high]) {
                if (nums[mid] == nums[low]) {
                    return Math.min(find(nums,low,mid), find(nums,mid+1,high));
                }
                high = mid;
            }
            else if (nums[mid] < nums[high]) high = mid;
            else low = mid + 1;
        }
        return nums[low];
    }
}
