class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLastWord(self, s):
        s = s.strip()
        strArray = s.split(' ')
        return strArray == [] and 0 or len(strArray[len(strArray) - 1])
