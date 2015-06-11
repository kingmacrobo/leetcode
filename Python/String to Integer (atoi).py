class Solution:
    # @param {string} str
    # @return {integer}
    def myAtoi(self, str):
        str = str.strip()
        sig = 1
        if not len(str):
            return 0
        if str[0] == '-' or str[0] == '+':
            sig = str[0] == '+' and 1 or -1
            str = str[1:]
        ret = 0
        for ch in str:
            if not (ord(ch) >= ord('0') and ord(ch) <= ord('9')):
                break
            ret *= 10
            ret += int(ch)
        if ret >= 2147483648 and sig == 1:
            ret = 2147483647
        elif ret > 2147483648 and sig == -1:
            ret = 2147483648
        return ret * sig
