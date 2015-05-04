public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for (int i = 0 ; i < nums.length ; ++i) {
            hash.put(nums[i],i+1);
        }
        for(int i = 0 ; i < nums.length ; ++i) {
            if(hash.containsKey(target - nums[i])) {
                if(i+1 == hash.get(target - nums[i]))
                    continue;
                result[0] = i+1 ;
                result[1] = hash.get(target-nums[i]);
                break;
            }
        }
        
        return result;
    }
}
