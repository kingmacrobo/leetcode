class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    def convert(self, s, numRows):
        str = [[] for i in range(0, numRows)]
        pt  = 0
        add = 0
        for i in range(0,len(s)):
            str[pt].append(s[i])
            if pt == numRows - 1 and pt != 0:
                add = -1
            elif pt == 0 and pt != numRows - 1:
                add = 1
            pt += add
        return "".join(["".join(str[i]) for i in range(0, numRows)])
