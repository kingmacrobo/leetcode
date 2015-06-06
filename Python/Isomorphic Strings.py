class Solution:
    # @param {string} s
    # @param {string} t
    # @return {boolean}
    def isIsomorphic(self, s, t):
        if len(s) != len(t):
            return False
        map1 = {}
        map2 = {}
        for i in range(0, len(s)):
            if map1.has_key(t[i]) and map1[t[i]] == s[i]:
                continue
            elif map1.has_key(t[i]):
                return False
            if map2.has_key(s[i]) and map2[s[i]] == t[i]:
                continue
            elif map2.has_key(s[i]):
                return False
            map1[t[i]] = s[i]
            map2[s[i]] = t[i]
        return True
