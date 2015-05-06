// use the strategy of cycle
// time is O(n) space is O(n)
public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer() ;
        int cycle = numRows + numRows -2;
        if ( cycle == 0) return s ;
        for (int i = 0 ; i < numRows ; ++i) {
            if (i != 0 && i != numRows - 1) {
                for (int j = i, k = cycle - i ; j < s.length() || k < s.length() ; j += cycle, k += cycle) {
                    if (j < s.length()) {
                        result.append(s.charAt(j)) ;
                    }
                    if (k < s.length() ) {
                        result.append(s.charAt(k)) ;
                    }
                    
                }
            }
            else {
                for (int j = i; j < s.length() ; j += cycle){
                    result.append(s.charAt(j)) ;
                }
            }
        }
        
        return result.toString();
    }
}
