// be careful with the overflow case 
// use the formula : result = result * 10 + bit ;
public class Solution {
    public int reverse(int x) {
        int result = 0, signal = 1;
        if (x == 0) return 0 ;
        if (x < 0) { 
            signal = -1 ;
            x = -x ;
        }
        while (x > 0) {
            int bit = x % 10 ;
            // deal with overflow
            if ((Integer.MAX_VALUE - bit) / 10 < result )
                return 0;
            result = result * 10 + bit ;
            x /= 10 ;
        }
        return result * signal ;
    }
}
