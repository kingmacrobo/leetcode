class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {boolean}
    def containsNearbyDuplicate(self, nums, k):
        length = min(k+1, len(nums))
        s = set()
        for i in range(0, length):
            if nums[i] in s:
                return True
            s.add(nums[i])
        if length == len(nums) + 1:
            return False
        for i in range(length, len(nums)):
            s.remove(nums[i-k-1])
            if nums[i] in s:
                return True
            s.add(nums[i])
        return False
