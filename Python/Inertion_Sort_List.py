#!/usr/bin/env python
# coding=utf-8
# Definition for singly-linked list.
# class ListNode:
#   def __init__(self, x):
#       self.val = x
#       self.next =None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def insertionSortList(self, head):
        p = ListNode(-(1<<32))
        p.next = head
        r = p
        q = head
        while q:
            if q.val >= r.val:
                q = q.next
                r = r.next
            else:
                pre = p
                cur = p.next
                r.next = q.next
                while True:
                    if q.val < cur.val:
                        q.next = cur
                        pre.next = q
                        break
                    pre = pre.next
                    cur = cur.next
                q = r.next
        return p.next
