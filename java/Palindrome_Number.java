// compare the reverse value with the origin value
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 ) return false ;
        int revers = 0 , t = x;
        while ( t > 0 ){
            revers = revers * 10 + t % 10 ;
            t /= 10 ;
        }
        if ( x == revers) return true ;
        return false ;
    }
}
