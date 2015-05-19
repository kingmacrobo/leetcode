// binary search
// time is O(logn), space is O(1)
public class Solution {
    public int search (int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (nums[mid] < target && nums[high] >= target)
                    low = mid + 1;
                else 
                    high = mid - 1;
            }
        }
        return -1;
    }
}
