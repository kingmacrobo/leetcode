// using bit manipulation
// time is O(1), space is the length of hashmap
public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long upper,divi = dividend,divis = divisor,result = 0;
        int digit = 0;
        HashMap<Long,Integer> table = new HashMap<Long,Integer>();
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            sign = -1;
        divi = divi >= 0 ? divi : -divi;
        divis = divis >= 0 ? divis : -divis;
        upper = divis;
        table.put(upper,0);
        while ((upper << 1) - 1 <= Integer.MAX_VALUE) {
            upper <<= 1;
            table.put(upper,++digit);
        }
        while (upper >= divis) {
            if (upper <= divi) {
                digit = table.get(upper);
                result += (long)1 << digit ;
                divi -= upper ;
            }
            upper >>= 1;
        }   
        if (sign == 1 && result > Integer.MAX_VALUE || sign == -1 && -result < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return sign == 1 ? new Long(result).intValue() : new Long(-result).intValue();
    }    
}
