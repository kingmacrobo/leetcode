
// From the array end , search forward untile the current numbe is greater than the number before it, 
// let make the front number the target and the index is i-1.
// And then, search backward until we find the minimum one that greater than the target, swap the two number in place.
// Finally, we sort the numbers start from the index of i in ascending order. So we find the next permutation.
// 
// The worst case is like that : 54321 -> 12345 , 15432 - > 21345, etc
// The time complexity is O(n), space is O(1)
public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        for (int i = length-1 ; i >= 0 ; --i) {
            if (i > 0 && nums[i] > nums[i-1]) {
                int j = i;
                while (j < nums.length && nums[j] > nums[i-1]) ++j;
                --j;
                int temp = nums[j];
                nums[j] = nums[i-1];
                nums[i-1] = temp;
                sort(nums,i);
                return ;
            }
        }
        sort(nums,0);
    }
    public void sort(int[] nums, int index) {
        int start = index, end = nums.length -1;
        while(start<end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
