class Solution:
    # @param {string} s
    # @return {integer}
    def calculate(self, s):
        self.pt = 0
        return self.cal(s)

    def cal(self, s):
        ans = 0
        sig = 1
        add = 0
        while self.pt < len(s):
            if s[self.pt] == '(':
                self.pt += 1
                add = self.cal(s)
                ans += add * sig
                add = 0
                sig = 1
            elif s[self.pt] == ')':
                self.pt += 1
                return ans + add * sig
            elif s[self.pt] == ' ':
                self.pt += 1
            elif s[self.pt] == '+' or s[self.pt] == '-':
                ans += add * sig
                sig = s[self.pt] == '+' and 1 or -1
                add = 0
                self.pt += 1
            else:
                add *= 10
                add += int(s[self.pt]) - int('0')
                self.pt += 1
        return ans + add * sig
