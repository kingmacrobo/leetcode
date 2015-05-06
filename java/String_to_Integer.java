// we should be careful with those tips :
// 1. header white space 
// 2. minus or plus sign
// 3. addtional invalid characters after the valid number
// 4. return 0 in invalid cases
// 5. overflow cases
public class Solution {
    public int myAtoi(String str) {
        int sign = 1 ;
        long result = 0;
        boolean getSign = false ;
        for (int i = 0 ; i < str.length() ; ++i) {
            char bit = str.charAt(i) ;
            // deal with header space
            if (!getSign && bit == ' ') continue ;
            // deal with sign
            if (!getSign) {
                if (bit <= '9' && bit >= '0') {
                    getSign = true ;
                }
                else {
                    if (bit != '-' && bit != '+')
                        return 0;
                    sign = bit == '-' ? -1 : 1 ;
                    getSign = true;
                    continue ;
                }
            }
            // deal with invalid characters
            if (bit < '0' || bit > '9')
                break ;
            result = result * 10 + bit - '0' ;
            // deal with overflow
            if ((sign == 1 && result > Integer.MAX_VALUE) || (sign == -1 && -result < Integer.MIN_VALUE)) {
                result = sign * (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                break ;
            }
            
        }
        return (int)result*sign ;
    }
}
