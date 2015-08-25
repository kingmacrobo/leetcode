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

// Another solution :
// Time also O(n), space also O(1).

public class Solution {
    public int maxProduct(int[] nums) {
        int product = 1, firstNeg = 1, preNeg = 1, max = 0;
        int firstLoc = -1, preLoc = -1, count = 0;
        boolean first = false, noZero = false, hasZero = false;
        for (int i = 0; i <= nums.length; ++i) {
            if (i == nums.length || nums[i] == 0) {
                if (i != nums.length) hasZero = true;
                if (!noZero) continue;
                if (count == 1) max = max == 0 ? product : Math.max(max,product);
                else {
                    max = Math.max(max,Math.max(product, Math.max(product/preNeg, product/firstNeg)));
                    if (firstLoc != -1) {
                        max = Math.max(max, firstNeg/nums[firstLoc]);
                        max = Math.max(max, preNeg/nums[preLoc]);
                    }
                }
                product = firstNeg = preNeg = 1;
                firstLoc = preLoc = -1;
                noZero = first = false;
                count = 0;
            }
            else {
                count++;
                noZero = true;
                product *= nums[i];
                if (nums[i] < 0) {
                    if (!first) {
                        firstLoc = i;
                        first = true;
                        firstNeg *= nums[i];
                    }
                    preLoc = i;
                    preNeg = nums[i];
                }
                else {
                    preNeg *= nums[i];
                }
                if (!first) {
                    firstNeg *= nums[i];
                }
            }
        }
        return hasZero ? Math.max(max,0) : max;
    }
}

// The best solution :
public class Solution {
    public int maxProduct(int[] nums) {
        int pre = 1, suf = 1, max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            pre *= nums[i];
            suf *= nums[n-i-1];
            max = Math.max(max, Math.max(pre,suf));
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
        }
        return max;
    }
}
