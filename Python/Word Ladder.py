class Solution:
    # @param beginWord, a string
    # @param endWord, a string
    # @param wordDict, a set<string>
    # @return an integer
    def ladderLength(self, start, end, dict):
        set1 = set([start])
        set2 = set([end])
        layer = 0
        while len(set1):
            set3 = set([])
            for word in set1:
                for i in range(len(word)):
                    for ch in range(ord('a'), ord('z') + 1):
                        if word[i] == chr(ch):
                            continue
                        newword = word[:i] + chr(ch) + word[i+1:]
                        if newword in set2:
                            return layer + 2
                        if newword in dict:
                            set3.add(newword)
                            dict.remove(newword)
            if len(set3) <= len(set2):
                set1 = set3
            else:
                set1 = set2
                set2 = set3
            layer += 1
        return 0
