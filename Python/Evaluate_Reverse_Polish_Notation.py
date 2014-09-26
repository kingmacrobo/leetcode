#!/usr/bin/env python
# coding=utf-8

class Solution:
    # @param tokens, a list of a string
    # @return an integer
    def evalRPN(self, tokens):
        mstack = []
        for token in tokens:
            if token in ("+", "-", "*", "/"):
                b=mstack.pop()
                a=mstack.pop()
                if token == "+":
                    mstack.append(a+b)
                elif token == "-":
                    mstack.append(a-b)
                elif token == "*":
                    mstack.append(a*b)
                elif token == "/":
                    c=a/b
                    if c<0 and float(c) != float(a)/float(b):
                        c += 1
                    mstack.append(c)
            else:
                mstack.append(int(token))
        return mstack.pop()


