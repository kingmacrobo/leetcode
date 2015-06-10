class Node:
    def __init__(self, rank, curID):
        self.preLevelRank = rank
        self.cur = curID

class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return a list of lists of string
    def findLadders(self, start, end, dict):
        if start in dict:
            self.startID = dict.index(start)
        else:
            dict.append(start)
            self.startID = len(dict) - 1

        if end in dict:
            self.endID = dict.index(end)
        else:
            dict.append(end)
            self.endID = len(dict) - 1

        self.makeTable(dict)

        visit = [False for i in range(len(dict))]
        pathFound = False
        curLayer = 0
        layerVisit = []
        layerVisit.append([Node(-1,self.startID)])
        visit[self.startID] = True
        while len(layerVisit[curLayer]) != 0 and not pathFound:
            layerVisit.append([])
            for i in range(len(layerVisit[curLayer])):
                ID = layerVisit[curLayer][i].cur
                for j in range(len(self.hashmap[ID])):
                    if visit[self.hashmap[ID][j]]:
                        continue
                    if self.hashmap[ID][j] == self.endID:
                        pathFound = True
                    layerVisit[curLayer+1].append(Node(i, self.hashmap[ID][j]))
            curLayer += 1
            for i in range(len(layerVisit[curLayer])):
                visit[layerVisit[curLayer][i].cur] = True

        ret = []
        pt = 0
        if pathFound:
            for node in layerVisit[curLayer]:
                if node.cur != self.endID:
                    continue
                ret.append([1 for i in range(curLayer+1)])
                layer = curLayer
                while layer != -1:
                    ret[pt][layer] = dict[node.cur]
                    layer -= 1
                    if layer != -1:
                        node = layerVisit[layer][node.preLevelRank]
                pt += 1
        return ret


    def makeTable(self, dict):
        self.hashmap = [[] for i in range(len(dict))]
        for i in range(len(dict)):
            for j in range(i+1, len(dict)):
                if self.isTrans(dict[i], dict[j]):
                    self.hashmap[i].append(j)
                    self.hashmap[j].append(i)

    def isTrans(self, start, end):
        count = 0
        for i in range(len(start)):
            if start[i] != end[i]:
                count += 1
        return count == 1
