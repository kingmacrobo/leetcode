// Find the next ugly number from the previous one.
// Time : not sure, space is O(n);

public class Solution {
    public int nthUglyNumber(int n) {
        List<Long> pre = new ArrayList<Long>();
        pre.add(new Long(1));
        for (int i = 2; i <= n; ++i) {
            long p = pre.get(i-2);
            int j = i-2;
            long min = p*2;
            while (j >= 0 && pre.get(j)*5 > p) {
                long k = pre.get(j--);
                if (k*2 > p) min = Math.min(min,k*2);
                if (k*3 > p) min = Math.min(min,k*3);
                if (k*5 > p) min = Math.min(min,k*5);
            }
            pre.add(min);
        }
        return new Long(pre.get(n-1)).intValue();
    }
}
