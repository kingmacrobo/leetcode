// Quick Sort's Swap method!
// When we find the base's location is k, we get the answer!
// Time is O(n), space is O(logn) since we use recursive method.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }
    public int quickSort(int[] nums, int start, int end, int k) {
        int a = start, b = end;
        int base = nums[a];
        boolean R = true;
        while (a < b) {
            if (R) {
                if (nums[b] < base) --b;
                else {
                    R = false;
                    nums[a++] = nums[b];
                }
            }
            else {
                if (nums[a] >= base) ++a;
                else {
                    R = true;
                    nums[b--] = nums[a];
                }
            }
        }
        nums[a] = base;
        if (a == k-1) return base;
        if (a < k-1) return quickSort(nums, a+1, end, k);
        return quickSort(nums, start, a-1, k);
    }
}

// HeapSort solution
// Add each element to heap, and pop  k-1 times, and then the top of the heap is the answer.
// Time is nlogn, space is O(1).

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (a == b) return 0;
                return a < b ? 1 : -1;
            }
        });
        for (int i = 0; i < nums.length; ++i)
            pq.offer(nums[i]);
        for (int i = 0; i < k-1; ++i)
            pq.poll();
        return pq.poll();
    }
}

// We can reduce the heapSort solution to O(nlogk) by using a k size min-heap.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; ++i) {
            if (pq.size() < k)
                pq.offer(nums[i]);
            else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}

// Heap Sort method without using priority queue:

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] kHeap = new int[k];
        for (int i = 0; i < k; ++i)
            kHeap[i] = nums[i];
        fixHeap(kHeap);
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > kHeap[0]) {
                kHeap[0] = nums[i];
                fixDownHeap(kHeap,0);
            }
        }
        return kHeap[0];
    }
    public void fixHeap(int[] kHeap) {
        for (int i = kHeap.length/2-1; i >= 0; --i)
            fixDownHeap(kHeap,i);
    }
    public void fixDownHeap(int[] kHeap, int loc) {
        int left = loc*2+1, right = loc*2+2, n = kHeap.length, minLoc = -1;
        if (left >= n) return;
        if (right >= n) minLoc = left;
        else minLoc = kHeap[left] < kHeap[right] ? left : right;
        if (kHeap[loc] <= kHeap[minLoc]) return;
        kHeap[loc]    ^= kHeap[minLoc];
        kHeap[minLoc] ^= kHeap[loc];
        kHeap[loc]    ^= kHeap[minLoc];
        fixDownHeap(kHeap, minLoc);
    }
}
