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


// Another esay understand method :
// Caculate the two side numbers at each ten digit bit.
// Time is O(logn), space is O(1).

public class Solution {
    public int countDigitOne(int n) {
        long k = 1, count = 0, bit = 0;
        while (n/k > 0) {
            long m = (n % (k*10))/k;
            long b = (n % k) + 1;
            long a = n / (k*10) + 1;
            if (m == 0) {
                count += (a-1) * k;
            }
            else if (m == 1){
                count += (a-1) * k + b;
            }
            else {
                count += a * k;
            }
            bit++;
            k *= 10;
        }
        return (int)count;
    }
}
