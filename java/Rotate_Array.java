// We can find all the eventually location of all the numbers by iteration method.
// Time is O(n), space is O(1).

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length, count = n;
        if (n == 0 ||(k %= n) == 0) return;
        for (int w = 0; w < k; ++w) {
            int pre = nums[w], i = w;
            while (count > 0) {
                int j = i >= n-k ? i-n+k : i+k;
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
                i = j;
                count--;
                if (j == w) break;
            }
            if (count == 0) break;
        }
    }
}
