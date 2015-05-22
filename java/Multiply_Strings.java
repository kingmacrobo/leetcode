// Big number multiply
// Calculate every digit : digit[k] = Σnum1[i]*num2[j], where i+j = k
// Time is O(mn), space is O(n+m), where m is the length of num1 and n is the length of m.
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] digits = new int[len1+len2];
        for (int i = 0 ; i < len1+len2-1; ++i) {
            int sum = 0;
            for (int j = 0 ; j < len1; ++j) {
                int k = i - j;
                if (k>=0 && k < len2) {
                    sum += (num1.charAt(len1-j-1)-'0')*(num2.charAt(len2-k-1)-'0');
                }
            }
            digits[i] = sum;
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < len1+len2-1; ++i) {
            sb.insert(0,(char)((carry + digits[i])%10+'0'));
            carry = (carry + digits[i]) / 10;
        }
        if (carry > 0) sb.insert(0,(char)(carry+'0'));
        return sb.toString();
    }
}
