// Binary Search!
// we can also take one part of each binary dividing on this problem because of the peek attribute.
// Time is O(logn), space is O(1).

public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (low+high)/2;
            if (mid == 0) {
                if (nums[mid] > nums[mid+1])
                    return mid;
                low = mid + 1;
            }
            else {
                if (nums[mid] > nums[mid-1]) {
                    if (nums[mid] > nums[mid+1])
                        return mid;
                    else low = mid + 1;
                }
                else high = mid - 1;
            }
            
        }
        return low;
    }
}
