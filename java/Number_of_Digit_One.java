// Math
// 0~9 contains one 1 int first digit, 0~99 contains 10 '1' in second digit, 0 ~ 999 contains 100 '1' in third digit.
// We just make n to divide 10, 100, 1000 .... to calculate the corrusponding digit 1s, and take care of the remaining.
// Time is O(logn), space is O(1).

public class Solution {
    public int countDigitOne(int n) {
        long result = 0, ten = 10, m = (long)n;
        while (m/ten > 0) {
            result += (m/ten)*(ten/10) + Math.max(0, Math.min(m%ten - ten/10 + 1,ten/10)); 
            ten *= 10;
        }
        result += Math.max(0, Math.min(m%ten - ten/10 + 1, ten/10));
        return (int)result;
    }
}
