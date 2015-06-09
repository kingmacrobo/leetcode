class Solution:
    # @param {integer} numerator
    # @param {integer} denominator
    # @return {string}
    def fractionToDecimal(self, numerator, denominator):
        sig = numerator < 0 and -1 or 1
        sig = denominator < 0 and sig * -1 or sig
        numerator = abs(numerator)
        denominator = abs(denominator)
        mystr = ('%s' % (numerator // denominator)).split()
        if numerator and sig == -1:
            mystr.insert(0, '-')
        numerator %= denominator
        if numerator:
            mystr.append('.')
        hashmap = {}
        pt = len(mystr)
        while numerator and not hashmap.get(numerator):
            hashmap[numerator] = pt
            numerator *= 10
            mystr.append(str(numerator // denominator))
            numerator %= denominator
            pt += 1
        if numerator:
            mystr.insert(hashmap[numerator], '(')
            mystr.append(')')
        return "".join(mystr)
