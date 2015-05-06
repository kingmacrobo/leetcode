// bit manipulation
// sum every bit and mod 3 to get the single num's bit value 
// time is O(n), space is O(1);
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0 ;
        for (int i = 0 ; i < 32 ; ++i ) {
            int count = 0 ;
            for (int j = 0 ; j < nums.length ; ++ j) {
                count += (nums[j] & 1<<i) >> i;
            }
            result |= (count%3) << i ;
        }
        return result ;
    }
}
