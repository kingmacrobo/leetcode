#!/usr/bin/env python
# coding=utf-8
# Definition for singly-linked list
# class ListNode:
#    def __init__(self, x):
#       self.val = x
#       self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def merge(self, h1, h2):
        if h1 == None: return h2
        if h2 == None: return h1
        if h1 == h2: return h1
#以下代码为TLE代码，每次都要判断是否为头节点，参考其他人思路设置一个伪节点        
#       retHead = None
#       retTail = None
#       while h1 != None and h2 != None:
#           if h1.val <= h2.val:
#               if retHead == None:
#                   retHead = h1
#                   retTail = h1
#               else:
#                   retTail.next = h1
#                   retTail = h1
#               h1 = h1.next
#           else:
#               if retHead == None:
#                   retHead = h2
#                   retTail = h2
#               else:
#                   retTail.next = h2
#                   retTail = h2
#               h2 = h2.next
        retHead = ListNode(-1)
        retTail = retHead
        while h1 and h2:
            if h1.val <= h2.val:
                small = h1
                h1 = h1.next
            else:
                small = h2
                h2 = h2.next
            retTail.next = small
            retTail = small
        if h1 == None:
            h1 = h2
        retTail.next = h1
#       return retHead
        return retHead.next

    def sortList(self, head):
        if head == None or head.next == None:
            return head
        p = head
        q = head
        while q.next and q.next.next:
            q = q.next.next
            p = p.next
        q = p.next
        p.next = None
        h1 = self.sortList(head)
        h2 = self.sortList(q)
        return self.merge(h1, h2)
