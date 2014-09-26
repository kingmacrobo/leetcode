#!/usr/bin/env python
# coding=utf-8

class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        words = s.split()
        ret = ''
        count = 0
        for word in words[::-1]:
            ret += word
            count += 1
            if count != len(words):
                ret +=' '
        return ret
