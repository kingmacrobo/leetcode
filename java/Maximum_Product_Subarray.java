// Separete the array by 0 to segments.
// Calculate each segment's max product by counting the negtive numbers's count.
// Time is O(n), space is O(1).

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, firstLoc = -1, lastLoc = -1, start = 0;
        int negCount = 0, product = 0, max = Integer.MIN_VALUE;
        boolean hasZero = false;
        for (int i = 0; i <= n; ++i) {
            if (i == n ||nums[i] == 0) {
                if (i < n && nums[i] == 0) hasZero = true;
                if (negCount%2 == 1) {
                    int a = product, b = product;
                    if (negCount == 1 && start+1 == i)
                        product = nums[firstLoc];
                    else {
                        for (int j = start; j <= firstLoc; ++j)
                            a /= nums[j];
                        for (int j = lastLoc; j < i; ++j)
                            b /= nums[j];   
                        product = Math.max(a,b);
                    }
                }
                max = Math.max(product,max);
                firstLoc = lastLoc = -1;
                start = i+1;
                negCount = 0;
                product = 0;
                continue;
            }
            product = product == 0 ? 1 : product; 
            product *= nums[i];
            if (nums[i] < 0) {
                negCount++;
                if (firstLoc == -1)
                    firstLoc = i;
                lastLoc = i;
            }
        }
        return hasZero ? Math.max(0,max) : max;
    }
}
