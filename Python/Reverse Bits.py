class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        ret = 0
        pt = 31
        while n:
            ret |= n&1 and 1<<pt or 0
            n >>= 1
            pt -= 1
        return ret
