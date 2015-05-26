// Greedy method.
// Firstly, we should cut the prefix and suffix of the String p to make it like this:
//      s:  abcaaadefaaaghaaaijk => abc aaadefaaaghaaa ijk
//      p:  abc*def*gh*ijk =>  *def*gh*
// In the mean time, we should compare the suffix and prefix of String p whith String s. If not match, return false.
// Then, we just use greedy method to find every substring separated by '*'. In the above cases, we should find the substring
// "def" and "gh" in the String of s as early as we can by greedy method!
// Time is O(n^2) under the worst cases and O(n) under the best cases, space is O(1).

public class Solution {
	    public boolean isMatch(String s, String p) {
	        int pre = 0, end = p.length()-1;
	        StringBuilder prefix = new StringBuilder();
	        StringBuilder suffix = new StringBuilder();
	        for (pre = 0; pre < p.length(); ++pre) {
	            if (p.charAt(pre) == '*') break;
	            prefix.append(p.charAt(pre));
	        }
	        
	        for (int i = 0; i < prefix.length(); ++i) {
	            if (i >= s.length() || prefix.charAt(i) != '?' && s.charAt(i) != prefix.charAt(i))
	                return false;
	        }
	        if (pre == p.length()) {
	        	if (prefix.length() != s.length()) return false;
	        	return true;
	        }
	        for (;end >= 0; --end) {
	            if (p.charAt(end) == '*') break;
	            suffix.append(p.charAt(end));
	        }
	        for (int i = 0; i < suffix.length(); ++i) {
	            if (i >= s.length() || suffix.charAt(i) != '?' && s.charAt(s.length()-i-1) != suffix.charAt(i))
	                return false;
	        }
	        int s_end = s.length()-suffix.length()-1;
	        int p_end = end;
	        if (pre > s_end+1) return false;
	        
	        int si = pre, pi = pre;
	        while (pi <= p_end) {
	            char c = p.charAt(pi);
	            if (c == '*') { 
	            	pi++;
	            	continue;
	            }
	            int temp = pi;
	            while (si <= s_end)
	                if (s.charAt(si++)==c || c == '?'){
	                	pi++;
	                	break;
	                }
	            
	            int a = si,b = pi;
	            while (a<=s_end && b<=p_end && (s.charAt(a)==p.charAt(b)||p.charAt(b)=='?')) {
	                a++;
	                b++;
	            }
	            if (a > s_end) {
	                if (b >= p_end) return true;
	                while (b <= p_end) {
	                	if (p.charAt(b++) != '*') return false;	                	
	                }
	                return true;
	            }
	            if (p.charAt(b) != '*') {
	            	pi = temp;
	                continue;
	            }
	            pi = b+1;
	            si = a;
	        }
	        return true;
	    }
}
