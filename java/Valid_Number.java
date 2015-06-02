// There are so many cases we should consider:
// ".1", "1.", "+1.e-8", "  -.2e+8  "...
// We should be careful of all these cases!
// Time is O(n), space is O(1).

public class Solution {
    public boolean isNumber(String s) {
        boolean head_blank = true, e_visited = false, dot_visited = false;
        boolean pre_digit = false, mid_digit = false, after_digit = false;
        boolean pre_sign = false, after_sign = false;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (head_blank) continue;
                while (i < s.length()) {
                    if (s.charAt(i++) != ' ')
                        return false;
                }
                break;
            }
            head_blank = false;
            if (c < '0' || c > '9') {
                if (c == '-' || c == '+') {
                    if (!pre_sign && !pre_digit && !dot_visited && !e_visited) {
                        pre_sign = true;
                        continue;
                    }
                    if (e_visited && !after_sign && !after_digit) {
                        after_sign = true;
                        if (i == s.length()-1) return false;
                        continue;
                    }
                    return false;
                }
                if (!e_visited && c == 'e') {
                    e_visited = true;
                    continue;
                }
                if (!e_visited && !dot_visited && c == '.') {
                    dot_visited = true;
                    continue;
                }
                return false;        
            }
            if (!e_visited && !dot_visited)
                pre_digit = true;
            else if (dot_visited && !e_visited)
                mid_digit = true;
            else if (e_visited)
                after_digit = true;
                
        }
        if (dot_visited && e_visited)
            return (pre_digit||mid_digit) && after_digit;
        else if (dot_visited && !e_visited)
            return pre_digit||mid_digit;
        else if (!dot_visited && e_visited)
            return pre_digit && after_digit;
        else
            return pre_digit;
    }
}
