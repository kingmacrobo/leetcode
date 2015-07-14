// HashMap, Math
// Using a hashmap to record the remainder at each point.
// When we find the current remainder exits in the hashmap, we top the loop, and give out the result;
// We should use long to avoid the overflow cases of int!
// Time is TODO! space is TODO!

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> mods = new HashMap<Long, Integer>();
        long a = Long.valueOf(numerator);
        long b = Long.valueOf(denominator);
        boolean neg = false;
        if (a < 0 && b > 0 || a > 0 && b < 0)
            neg = true;
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a/b);
        long n = a%b;
        if (n == 0) {
            if (neg) sb.insert(0,'-');
            return sb.toString();
        }
        StringBuilder sbb = new StringBuilder();
        sb.append('.');
        while (n != 0) {
            if (mods.containsKey(n)) {
                int loc = mods.get(n);
                sbb.insert(loc,'(');
                sbb.append(')');
                break;
            }
            mods.put(n,sbb.length());
            n *= 10;
            while (n/b == 0) {
                sbb.append('0');
                mods.put(n,sbb.length());
                n *= 10;
            }
            long val = n/b;
            n = n%b;
            sbb.append(val);
        }
        sb.append(sbb);
        if (neg) sb.insert(0,'-');
        return sb.toString();
    }
}
