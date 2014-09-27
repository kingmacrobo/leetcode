#!/usr/bin/env python
# coding=utf-8
#Definition for a point
#class Point:
#   def __init__(self, a=0, b=0):
#       self.x = a
#       self.y = b

class Solution:
    # @param points, a list of points
    # @return an integer
    def maxPoints(self, points):
        ret = 0
        n = len(points)
        for i in range(n):
            hashmap = {}
            samePoint = 1
            for j in range(i+1, n):
                slope = float("inf")
                if points[i].x == points[j].x and points[i].y == points[j].y:
                    samePoint += 1
                    continue
                if points[i].x != points[j].x:
                    slope = float(points[j].y - points[i].y) / float(points[j].x - points[i].x)
                if hashmap.has_key(slope):
                    hashmap[slope] += 1
                else:
                    hashmap[slope] = 1
            tmp = samePoint
            if len(hashmap.values()) > 0:
                   tmp += max(hashmap.values())
            if tmp > ret:
                ret = tmp
        return ret
