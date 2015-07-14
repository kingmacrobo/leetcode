// Radix sort, Bucket sort.
// Sort the numbers using buckets and then find the max gap!
// Time is O(n), space is O(n).

public class Solution {
    public int maximumGap(int[] nums) {
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; ++i) {
            buckets.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < nums.length; ++i) 
            l1.add(nums[i]);
        Integer tens = 1;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < l1.size(); ++j) {
                int val = l1.get(j);
                int digit = (val/tens)%10;
                buckets.get(digit).add(val);
            } 
            for (int j = 0; j < 10; ++j) {
                List<Integer> bucket = buckets.get(j);
                for (int k = 0; k < bucket.size(); ++k)
                    l2.add(bucket.get(k));
                bucket.clear();
            }
            List<Integer> temp = l1;
            l1 = l2;
            l2 = temp;
            l2.clear();
            tens *= 10;
        }
        int max = 0;
        for (int i = 0; i < l1.size()-1; ++i) {
            max = Math.max(l1.get(i+1)-l1.get(i),max);
        }
        return max;
    }
}
