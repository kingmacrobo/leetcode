class Solution:
    # @param {string[]} words
    # @param {integer} maxWidth
    # @return {string[]}
    def fullJustify(self, words, maxWidth):
        LineS = []
        line = []
        Text = []
        length = maxWidth
        wordnum = 0
        for word in words:
            if length >= (wordnum + len(word)):
                line.append(word)
                wordnum += 1
                length -= len(word)
            else:
                line.append(length)
                LineS.append(line)
                length = maxWidth
                wordnum = 1
                line = [word]
                length -= len(word)
        if len(line):
            line.append(length)
            LineS.append(line)

        for i in range( 0, len(LineS) - 1):
            line = LineS[i]
            numspace = line[len(line) - 1]
            wordnum = len(line) - 1
            string = ''
            if wordnum == 1:
                string = line[0] + ' ' * numspace
                Text.append(string)
            else:
                averagespace = numspace // (wordnum-1)
                leftspace = numspace % (wordnum-1)
                for i in range(0, wordnum - 1):
                    if i < leftspace:
                        string += line[i] + ' '*(averagespace + 1)
                    else:
                        string += line[i] + ' '*averagespace
                string += line[wordnum - 1]
                Text.append(string)
        string = ''
        for i in range(0, len(LineS[len(LineS) - 1]) - 1):
            string = string + LineS[len(LineS) - 1][i] + ' '
        string = string[:-1]
        string += ' ' * (maxWidth - len(string))
        Text.append(string)
        return Text
