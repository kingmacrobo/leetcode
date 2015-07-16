// HashMap solution!
// Record the previous numbers by hash to judge whether there is a endless loop or not.
// Time todo, space todo!

public class Solution {
    Set<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if (set.contains(n)) return false;
        set.add(n);
        int sum = 0;
        while (n != 0) {
            int a = n%10;
            sum += a*a;
            n /= 10;
        }
        if (sum == 1) return true;
        return isHappy(sum);
    }
}
