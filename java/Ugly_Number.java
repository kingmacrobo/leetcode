// Ugly number
// Divide every 2, 3, 5
// Time is O(logn), space is O(1).

public class Solution {
    public boolean isUgly(int num) {
        while (num >= 2) {
            if (num%2 == 0) {
                num /= 2;
            }
            else if (num%3 == 0) {
                num /= 3;
            }
            else if (num%5 == 0) {
                num /= 5;
            }
            else break;
        }
        return num == 1;
    }
}
