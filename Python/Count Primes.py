class Solution:
    # @param {integer} n
    # @return {integer}
    def countPrimes(self, n):
        if n < 2:
            return 0
        listPrime=[True] * n
        listPrime[0] = listPrime[1] = False
        for i in range(2, int(n**0.5) + 1):
            if listPrime[i]:
                listPrime[i*i:n:i] = [False] * len(listPrime[i*i:n:i])
        return listPrime.count(True)
