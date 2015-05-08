// consider every Roman Number as a Integer value, and add them all
// we should minus the value in the situation that left roman is smaller than right roman, like IV.
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0 ; i < s.length() ; ++i) {
            char c = s.charAt(i);
            switch (c) {
                case 'M' :
                    if (i-1 >= 0 && s.charAt(i-1) == 'C')
                        result -= 200;
                    result += 1000 ;
                    break;
                case 'D' :
                    if (i-1 >= 0 && s.charAt(i-1) == 'C')
                        result -= 200;
                    result += 500 ;
                    break;
                case 'C' :
                    if (i-1 >= 0 && s.charAt(i-1) == 'X')
                        result -= 20;
                    result += 100 ;
                    break ;
                case 'L' :
                    if (i-1 >= 0 && s.charAt(i-1) == 'X')
                        result -= 20;
                    result += 50 ;
                    break;
                case 'X' :
                    if (i-1 >= 0 && s.charAt(i-1) == 'I')
                        result -= 2;
                    result += 10 ;
                    break ;
                case 'V' :
                    if (i-1 >= 0 && s.charAt(i-1) == 'I')
                        result -= 2;
                    result += 5 ;
                    break ;
                case 'I' :
                    result += 1;
                    break;
            }
        }
        return result ;
    }
}
