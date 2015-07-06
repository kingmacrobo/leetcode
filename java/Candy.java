// Fisrtly find the peak from left to right, and then down to the trough, in the meantime, add the value to sum.
// Iterate the process above, and the final sum is the answer.
// Time is O(n), space is O(1).

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, sum = 0, left = 0, right = 0;
        for (int i = 0; i < n;) {
            int start = i;
            while (start+1 < n && ratings[start] < ratings[start+1]) {
                start++;
            }
            int end = start;
            while (end+1 < n && ratings[end] == ratings[end+1]) {
                ++end;
            }
            for (int k = i; k <= start; ++k) {
                sum += ++left;
            }
            int after = end;
            while (after+1 < n && ratings[after] >= ratings[after+1]) {
                after++;
            }
            for (int k = after; k >= end+1; --k) {
                if (k != after && ratings[k] == ratings[k+1]) {
                    sum += 1;
                    right = 1;
                }
                else sum += ++right;
            }
            if (end == start) {
                if (left < ++right) {
                    sum += right - left;
                }
            }
            else {
                sum += ++right;
                sum += (end-start-1)*Math.min(left,right);
            }
            i = after+1;
            left = 1;
            right = 0;
        }
        return sum;
    }
}

// Another solution using extra space:
// Time is O(n), space is O(n).

public class Solution {
    public int candy(int[] ratings) {
        int sum = 0, n = ratings.length;
        int[] num = new int[n];
        Arrays.fill(num,1);
        for (int i= 1; i < n; ++i) {
            if (ratings[i]  > ratings[i-1])
                num[i] = num[i-1]+1;
        }
        for (int i = n-2; i >= 0; --i) {
            if (ratings[i] > ratings[i+1]) {
                num[i] = Math.max(num[i],num[i+1]+1);
            }
        }
        for (int i = 0; i < n; ++i)
            sum += num[i];
        return sum;
    }
}
