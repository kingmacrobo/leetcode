class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @param {integer} t
    # @return {boolean}
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        length = min(k + 1, len(nums))
        s = set()
        for i in range(0, length):
            if t * 2 + 1 > len(s):
                for num in s:
                    if abs(num - nums[i]) <= t:
                        return True
            else:
                for num in range(nums[i] - t, nums[i] + t + 1):
                    if num in s:
                        return True
            s.add(nums[i])
        if length < len(nums):
            for i in range(k + 1, len(nums)):
                s.remove(nums[i-k-1])
                if t * 2 > k:
                    for num in s:
                        if abs(num - nums[i]) <= t:
                            return True
                else:
                    for num in range(nums[i] - t, nums[i] + t + 1):
                        if num in s:
                            return True
                s.add(nums[i])
        return False
