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


// There is a magic solution USING RING FAST SLOW METHOD JUST LIKE THE CYCLE IN A LINKED LIST!!!!

int digitSquareSum(int n) {
    int sum = 0, tmp;
    while (n) {
        tmp = n % 10;
        sum += tmp * tmp;
        n /= 10;
    }
    return sum;
}

bool isHappy(int n) {
    int slow, fast;
    slow = fast = n;
    do {
        slow = digitSquareSum(slow);
        fast = digitSquareSum(fast);
        fast = digitSquareSum(fast);
    } while(slow != fast);
    if (slow == 1) return 1;
    else return 0;
}
