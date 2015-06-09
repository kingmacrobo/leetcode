class Solution:
    # @param {integer} x
    # @return {integer}
    def reverse(self, x):
        sig = x<0 and -1 or 1
        x = abs(x)
        ret = 0
        while x:
            ret *= 10
            ret += x % 10
            x //= 10
        if ret > 2147483641 :
            ret = 0
        return ret * sig
