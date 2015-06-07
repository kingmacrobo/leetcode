import random

class Solution:
    # @param {integer} n
    # @return {integer}
    def countPrimes(self, n):
        count = 0
        for i in range(1, n+1):
            if self.isPrimer(i):
                count = count + 1
        return count

    # @param {integer} n
    # @return {boolean}
    def isPrimer(self, n):
        for i in range(0,10):
            a = random.randint(1,100)
            if self.pow_mod(a, n, n) != a % n:
                return False
        return True

    # @param {integer} a
    # @param {integer} n
    # @param {integer} m
    def pow_mod(self, a, n, m):
        if n == 0:
            return 1
        ans = self.pow_mod(a, n//2, m)
        ans = ans * ans % m
        if n % 2 == 1:
            ans = ans * a % m
        return ans
