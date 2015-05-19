// Binary search 
// This is more complicated than the one before.
// Time is O(n) in the worst case like "4144444444444444444444444444"
// but it will be O(logn) in the cases without duplicated numbers.

public class Solution {
    public boolean search(int[] nums, int target) {
        return find(nums,target,0,nums.length-1);
    }
    public boolean find(int[] nums, int target, int low, int high) {
        if (low > high) return false; 
        int mid = (low+high)/2;
        if (nums[mid] == target) return true;
        if (nums[low] < nums[mid]) {
            if (target < nums[mid] && target >= nums[low]) {
                return find(nums,target,low,mid-1);
            } else {
                return find(nums,target,mid+1,high);
            }
        }else if (nums[low] == nums[mid]) {
            if (nums[mid] == nums[high]) {
                return find(nums,target,low,mid-1) || find(nums,target,mid+1,high);
            }else {
                return find(nums,target,mid+1,high);
            }
        }
        else {
            if (target > nums[mid] && target <= nums[high]) {
                return find(nums,target,mid+1,high);
            }
            else {
                return find(nums,target,low,mid-1);
            }
        }
    }
}
