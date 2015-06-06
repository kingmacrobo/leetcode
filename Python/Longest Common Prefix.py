class Solution:
    # @param {string[]} strs
    # @return {string}
    def longestCommonPrefix(self, strs):
        if len(strs) == 0:
            return ""
        elif len(strs) == 1:
            return strs[0]
        s1 = strs[0]
        for s2 in strs:
            s1 = len(s1) <= len(s2) and s1[:] or s1[:len(s2)] #三元操作符的使用
            for i in range(len(s1)):
                if s1[i] != s2[i]:
                    s1 = s1[:i]
                    break
        return s1
