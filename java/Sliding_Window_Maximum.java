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

// Monotonic Reducing Queue.
// Time : O(n) ??, space is O(k).

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        if (nums.length == 0 || k == 0) return new int[0];
        MonotonicQueue mq = new MonotonicQueue();
        for (int i = 0 ; i < k; ++i)
            mq.push(new Node(i,nums[i]));
        for (int i = 0; i < nums.length-k+1; ++i) {
            result[i] = mq.peek(i);
            if (i+k < nums.length) mq.push(new Node(i+k,nums[i+k]));
        }
        return result;
    }
    class MonotonicQueue {
        Node head, tail;
        public void push(Node node) {
            if (head == null) {
                head = tail = node;
            }
            else {
                Node p = tail;
                while (p != null) {
                    if (p.val >= node.val) {
                        p.next = node;
                        node.pre = p;
                        node.next = null;
                        tail = node;
                        break;
                    }
                    p = p.pre;
                    
                }
                if (p == null) {
                    node.next = head;
                    head.pre = node;
                    node.next = node.pre = null;
                    head = tail = node;
                }
            }
        }
        public int peek(int start) {
            Node p = head;
            while (p != null) {
                if (p.index >= start) {
                    break;
                }
                p = p.next;
            }
            head = p;
            p.pre = null;
            return p.val;
        }
    }
    class Node {
        int index, val;
        Node next, pre;
        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
