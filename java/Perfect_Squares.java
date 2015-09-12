// dp solution
// dp(n) = min{dp(i) + 1}, 1 <= i <= sqrt(n).
// Time is not sure! Space is the size of Hashtable.

public class Solution {
    public int numSquares(int n) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        return dp(n, record);
    }
    public int dp(int n, HashMap<Integer, Integer> record) {
        if (record.containsKey(n)) return record.get(n);
        int a = (int)Math.sqrt(n);
        if (a*a == n) {
            record.put(n, 1);
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = a; i >= 1; --i) {
            min = Math.min(min, dp(n - i*i, record));
        }
        record.put(n, min+1);
        return min+1;
    }
}
