// Roman numeral is : I,V,X,L,C,D,M
// we should consider this cases in every digit:
//    0~3 , 4 , 5~8, 9 
// their Roman number is (in 1 digit): 
//  I ~ III, IV, V~VIII, IX
public class Solution {
    public String intToRoman(int num) {
    	char[][] d = {{'I','V','X'},{'X','L','C'},{'C','D','M'},{'M','-','-'}} ;
        StringBuffer result = new StringBuffer() ;
        int digit = 0 ;
        while (num > 0) {
            int value = num % 10 ;
            if (value < 4) while(value-- > 0) result.insert(0,d[digit][0]) ;
            else if (value == 4) result.insert(0,new char[]{d[digit][0],d[digit][1]}) ;
            else if (value < 9) {
                while (value-- > 5) result.insert(0,d[digit][0]) ;
                result.insert(0,d[digit][1]) ;
            }
            else result.insert(0,new char[]{d[digit][0],d[digit][2]}) ;
            num /= 10 ;
            ++digit ;
        }
        return result.toString() ;
    }
}
