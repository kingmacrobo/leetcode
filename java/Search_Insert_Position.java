
// Binary search
// we should be careful with the situation of the end.
// we use a flag to determine whether add one to the mid or keep mid to be our result.
// time is O(logn)
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int flag = 0, mid = 0;
        while (low <= high) {
            mid = (low+high)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                high = mid - 1;
                flag = 0;
            }
            else {
                low = mid + 1;
                flag = 1;
            }
        }
        return mid + flag;
    }
}
