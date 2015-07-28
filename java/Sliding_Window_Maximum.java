// Max Heap solution
// Time is O(nlogk), space is O(k).

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] result = new int[n-k+1];
        PriorityQueue<Integer> heap = new PriorityQueue(n, new Comparator<Integer>(){
            @Override 
            public int compare(Integer a, Integer b) {
                if (a == b) return 0;
                return a < b ? 1 : -1;
            }
        });
        for (int i = 0; i < k; ++i) 
            heap.offer(nums[i]);
        for (int i = 0; i < n-k+1; ++i) {
            result[i] = heap.peek();
            heap.remove(nums[i]);
            if (i+k < n) heap.offer(nums[i+k]);
        }
        return result;
    }
}
