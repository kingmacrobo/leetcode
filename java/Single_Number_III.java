// Bit manipulation
// Xor all the numbers to find the a^b
// find a 1 bit in a^b and divide the nums to two group
// xor each group to find the answer.
// Time is O(n), space is O(1).

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xall = 0;
        int[] result = new int[2];
        for (int a : nums) 
            xall ^= a;
        int bit = 0;
        for (;bit < 32; ++bit) {
            if (((xall >> bit) & 1) == 1)
                break;
        }
        Arrays.fill(result,0);
        for (int a : nums) {
            if (((a >> bit) & 1) == 1)
                result[0] ^= a;
            else
                result[1] ^= a;
        }
        return result;
    }
}
