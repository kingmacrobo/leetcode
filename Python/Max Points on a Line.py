class Solution:
    # @param {Point[]} points
    # @return {integer}
    def maxPoints(self, points):
        ret = 0
        n = len(points)
        for i in range(0, n):
            hashmap = {}
            samepoints = 1
            for j in range(i+1, n):
                slope = float("inf")
                if points[j].x == points[i].x and points[j].y == points[i].y:
                    samepoints += 1
                    continue
                if points[j].x != points[i].x:
                    slope = float(points[j].y - points[i].y) / float(points[j].x - points[i].x)
                if hashmap.has_key(slope):
                    hashmap[slope] += 1
                else:
                    hashmap[slope] = 1
            if len(hashmap) == 0:
                ret = max(ret, samepoints)
            else:
                ret = max(ret, samepoints + max(hashmap.values()))
        return ret
