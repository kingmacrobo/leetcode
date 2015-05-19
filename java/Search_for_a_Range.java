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

// There is another method that can reduce the worst time to O(logn)
// We can still use the binary search strategy when we find a target number, other than searching linearly in two directions.
// here is my code :
public class Solution {
    public int[] searchRange(int[] nums, int target) {
         int low = 0, high = nums.length-1;
         while (low <= high) {
             int mid = (low+high)/2;
             if (nums[mid] == target) {
                int l = low; 
                int[] result = new int[]{mid,mid};
                low = mid + 1;
                while (low < high) {
                    int m = (low+high)/2;
                    if (nums[m] == nums[mid]) low = m+1;
                    else high = m-1;
                }
                if (low < nums.length && nums[low]==nums[mid]) result[1] = low;
                else result[1] = low-1;
                low = l;
                high = mid - 1;
                while (low < high) {
                    int m = (low+high)/2;
                    if (nums[m] == nums[mid]) high = m-1;
                    else low = m+1;
                }
                if (nums[low] == nums[mid]) result[0] = low;
                else result[0] = low + 1;
                return result;
             }
             else if (nums[mid] < target) low = mid + 1;
             else high = mid - 1;
         }
         return new int[]{-1,-1};
    }
}
