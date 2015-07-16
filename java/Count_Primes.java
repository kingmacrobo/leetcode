// Prime method : Filter Method！------Sieve of Eratosthenes : https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
// Time O(n*loglogn) , space O(n).

public class Solution {
    public int countPrimes(int n) {
        boolean[] not = new boolean[n];
        Arrays.fill(not, false);
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (not[i]) continue;
            count++;
            int k = i*2;
            while (k < n) {
                not[k] = true;
                k += i;
            }
        }
        return count;
    }
}
