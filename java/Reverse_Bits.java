//Bit manipulation
// Time O(1), space O(1).

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i)
            result = (result<<1)|((n>>i)&0x1);
        return result;
    }
}
