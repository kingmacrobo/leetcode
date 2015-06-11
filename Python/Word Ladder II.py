class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return a list of lists of string
    def findLadders(self, start, end, dict):
        self.head = start
        self.tail = end
        PathS = []
        hashmap = {}
        hashmap[start] = [[start]]
        hashmap[end] = [[end]]
        set1 = {start}
        set2 = {end}
        if start in dict:
            dict.remove(start)
        if end in dict:
            dict.remove(end)
        pathFound = False
        while len(set1) and not pathFound:
            set3 = set()
            for word in set1:
                for i in range(len(word)):
                    for ch in range(ord('a'), ord('z')+1):
                        if word[i] == ch:
                            continue
                        newword = word[:i] + chr(ch) + word[i+1:]
                        if newword in set2:
                            pathFound = True
                            self.getPath(PathS, newword, word, hashmap)
                        elif newword in dict or newword in set3:
                            if newword in dict:
                                dict.remove(newword)
                            set3.add(newword)
                            if newword not in hashmap:
                                hashmap[newword] = []
                            for path in hashmap[word]:
                                copyPath = path[:]
                                copyPath.append(newword)
                                hashmap[newword].append(copyPath)
            if len(set3) <= len(set2):
                set1 = set3
            else:
                set1 = set2
                set2 = set3
        return PathS

    def getPath(self, PathS, nword, oword, hashmap):
        for path1 in hashmap[nword]:
            for path2 in hashmap[oword]:
                copypath1 = path1[:]
                copypath2 = path2[:]
                copypath2.reverse()
                path = copypath1 + copypath2
                if path[0] == self.tail:
                    path.reverse()
                PathS.append(path)
