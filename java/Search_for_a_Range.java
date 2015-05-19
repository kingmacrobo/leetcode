// Binary search 
// Extend in two direction when find the value to get the begin and end position.
// time: worst is O(n), best is O(logn).
public class Solution {
    public int[] searchRange(int[] nums, int target) {
         int low = 0, high = nums.length-1;
         while (low <= high) {
             int mid = (low+high)/2;
             if (nums[mid] == target) {
                 int start = mid, end = mid;
                 while (start >= 0 && nums[start] == nums[mid]) start--;
                 while (end < nums.length && nums[end]==nums[mid]) end++;
                 return new int[]{start+1, end - 1};
             }
             else if (nums[mid] < target) low = mid + 1;
             else high = mid - 1;
         }
         return new int[]{-1,-1};
    }
}
