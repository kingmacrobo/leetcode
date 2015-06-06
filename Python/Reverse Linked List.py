class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def reverseList(self, head):
        mockhead = ListNode(0)
        while head:
            p = head.next
            head.next = mockhead.next
            mockhead.next = head
            head = p
        return mockhead.next
