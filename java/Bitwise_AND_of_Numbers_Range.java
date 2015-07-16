// Bit Manipulation
// If one value's kth bit is 0, the result's kth bit is 0.
// So we just find whether the kth bit of the values could be 0 or not.
// Time is O(logn), space is O(1).

public class Solution {
	    public int rangeBitwiseAnd(int m, int n) {
	        int result = 0;
	        for (int i = 0; i < 31; ++i) {
	            int val = 1 << i;
	            int a = val << 1;
	            if ((n&val) == 0 || (m&val) == 0|| n/a > m/a)
	                continue;
	            result |= val;
	        }
	        return result;
	    }
}


// Another brilliant solution : find the comment prefix of m and n;
// Time is O(logn), space is O(1).

public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m<<=count;
    }
