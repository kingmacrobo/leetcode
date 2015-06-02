// Time and space is both O(n)

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0, sum;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                sum = carry + b.charAt(j--)-'0';
            }
            else if (j < 0) {
                sum = carry + a.charAt(i--)-'0';
            }
            else {
                sum = carry + a.charAt(i--)-'0' + b.charAt(j--)-'0';
            }
            sb.insert(0, (char)(sum % 2 + '0'));
            carry = sum / 2;
        }
        if (carry > 0)
            sb.insert(0,'1');
        return sb.toString();
    }
}

// It's interesting to simplify the code like this :

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry + 
                  (i < 0 ? 0 : a.charAt(i--)-'0') + 
                  (j < 0 ? 0 : b.charAt(j--)-'0');
            sb.insert(0, (char)(sum % 2 + '0'));
            carry = sum / 2;
        }
        return sb.toString();
    }
}
