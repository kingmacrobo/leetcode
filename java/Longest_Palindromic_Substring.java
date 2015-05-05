// method1 : use dp
// time is O(n^2) space is O(n^2)
// recurse formula: 
//    dp(i,j) = max{dp(i,j-1),dp(i+1,j)}  , s(i~j) isn't a palindromic.
//    dp(i,j) = j - i + 1 , s(i~j) is a palindromic
// this method1 get TLE in leetcode oj.

public class Solution {
    
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return null;
        Cell[][] record = new Cell[s.length()][s.length()];
        int[][] isPalin = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() ; ++i) {
            for (int j = 0; j < s.length() ; ++j) {
                isPalin[i][j] = -1 ;
                record[i][j] = new Cell();
            }
        }
        Cell result = dp(0,s.length()-1,s,record, isPalin);
        return s.substring(result.start,result.end+1);
    }
    private Cell dp(int start, int end, String s, Cell[][] record, int[][] isPalin) {
        if (record[start][end].max != 0) {
            return record[start][end] ;
        }
        if (start == end || isPal(start,end,s,isPalin) == 1) {
            record[start][end].start = start;
            record[start][end].end = end ;
            record[start][end].max = end - start + 1 ;
            return record[start][end] ;
        }
        Cell c1 = dp(start+1,end,s,record,isPalin) ;
        Cell c2 = dp(start,end-1,s,record,isPalin) ;
        if (c1.max > c2.max) {
            return record[start][end] = c1;
        }
        return record[start][end] = c2;
    }
    private int isPal (int start, int end, String s, int[][] isPalin) {
        if (start > end) {
            return 1 ;
        }
        if (isPalin[start][end] != -1) {
            return isPalin[start][end] ;
        }
        if (start == end) {
            return isPalin[start][end] = 1 ;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return isPalin[start][end] = 0 ;
        }
        
        return isPalin[start][end] = isPal(start+1,end-1,s,isPalin) ;
    }
    class Cell {
        int start ; 
        int end ;
        int max ; 
    }
}

// method2 : search in two side
// time is O(n^2)
// we should consider odd and even cases.

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length() ;
        int start = 0, end = 0, max = 1;
        if (n == 0 ) return null;
        // odd
        for (int i = 0 ; i < n ; ++i) {
            int low = i - 1 , high = i + 1;
            while(low >= 0 && high <= n - 1 ) {
                if (s.charAt(low) != s.charAt(high)) {
                    break ;
                }
                if (high - low + 1 > max) {
                    max = high - low + 1 ;
                    start = low ;
                    end = high ;
                }
                --low ;
                ++high ;
            }
        }
        //even
        for (int i = 0 ; i < n ; ++i) {
            int low = i , high = i + 1 ;
            while (low >= 0 && high <= n - 1 ) {
                if (s.charAt(low) != s.charAt(high)) {
                    break ;
                }
                if (high - low + 1 > max ) {
                    max = high - low + 1 ;
                    start = low ;
                    end = high ;
                }
                --low ;
                ++high ;
            }
        }
        return s.substring(start,end+1) ;
    }
}
