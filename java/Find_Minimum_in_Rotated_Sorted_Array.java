// Binary Search
// If we retate the array, there will a sub array that is sorted, and the minimum one is in another subarray.
// Time is O(logn), space is O(1).

public class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (low+high)/2;
            if (nums[mid] < nums[low]) {
                high = mid;
            }
            else if (nums[mid] < nums[high]) {
                break;
            }
            else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}
