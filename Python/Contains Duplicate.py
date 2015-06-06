class Solution:
    # @param {integer[]} nums
    # @return {boolean}
    def containsDuplicate(self, nums):
        map = {}
        for num in nums:
            if map.has_key(num):
                return True
            map[num] = num
        return False
