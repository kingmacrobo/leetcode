// Static Linked List method
// Create a static linkedlist to record each station's longest destination,
// which can avoid the repeating travel when we come to the station again!
// If the first time we roll back and can't find the answer, we'll returan -1, 
// because in this case we can make sure that ther stations after the current one 
// cannot be the answer too, which can be proved by contradiction.

// Time is O(n), space is O(n).

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] link = new int[n];
        int[] profit = new int[n];
        for (int i = 0; i < n; ++i) {
            link[i] = (i+1) % n ;
            profit[i] = gas[i]-cost[i];
        }
        for (int i = 0; i < n; ++i) {
            int j = i, sum = 0;
            while(sum+profit[j] >= 0) {
                sum += profit[j];
                j = link[j];
                if (i == j) return i;
            }
            if (j < i) return -1;
            profit[i] = sum + profit[j];
            link[i] = j+1;
            i = j;
        }
        return -1;
    }
}
