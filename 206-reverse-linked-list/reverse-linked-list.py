# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head: return None
        stack = []
        while head:
            stack.append(head.val)
            head = head.next
        
        head = ListNode(stack.pop())
        p = head
        while stack:
            p.next = ListNode(stack.pop())
            p = p.next
        return head

        