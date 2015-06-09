class Solution:
    # @param {string} s
    # @return {boolean}
    def isNumber(self, s):
        s = s.strip()
        hasE = False
        if 'e' in s:
            hasE = True
            str1 = s[:s.find('e')]
            str2 = s[s.find('e') + 1:]
        else:
            str1 = s[:]
            str2 = ''

        if len(str1) != 0 and (str1[0] == '-' or str1[0] == '+'):
            str1 = str1[1:]
        if hasE and len(str2) != 0 and (str2[0] == '-' or str2[0] == '+'):
            str2 = str2[1:]

        if len(str1) - str1.count('.') == 0 or str1.count('.') > 1 or (hasE and len(str2) == 0):
            return False
        for ch in str1:
            if ch != '.' and not (ch >= '0' and ch <= '9'):
                return False
        for ch in str2:
            if not (ch >= '0' and ch <= '9'):
                return False
        return True
