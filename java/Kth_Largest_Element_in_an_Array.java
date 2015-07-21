// Quick Sort's Swap method!
// When we find the base's location is k, we get the answer!
// Time is O(n), space is O(logn) since we use recursive method.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }
    public int quickSort(int[] nums, int start, int end, int k) {
        int a = start, b = end;
        int base = nums[a];
        boolean R = true;
        while (a < b) {
            if (R) {
                if (nums[b] < base) --b;
                else {
                    R = false;
                    nums[a++] = nums[b];
                }
            }
            else {
                if (nums[a] >= base) ++a;
                else {
                    R = true;
                    nums[b--] = nums[a];
                }
            }
        }
        nums[a] = base;
        if (a == k-1) return base;
        if (a < k-1) return quickSort(nums, a+1, end, k);
        return quickSort(nums, start, a-1, k);
    }
}
