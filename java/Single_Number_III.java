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
