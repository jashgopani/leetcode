# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def gcd(a, b):
            # Everything divides 0
            if (a == 0):
                return b
            if (b == 0):
                return a

            # Base case
            if (a == b):
                return a

            # a is greater
            if (a > b):
                return gcd(a-b, b)
            return gcd(a, b-a)
        temp = head
        while temp:
            if temp.next:
                gNode = ListNode(gcd(temp.val,temp.next.val))
                gNode.next = temp.next
                temp.next = gNode
                temp = temp.next
            temp = temp.next
        return head