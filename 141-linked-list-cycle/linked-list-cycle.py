# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next: return False
        
        slow = head
        fast = head.next.next

        while fast and slow and fast != slow:
            fast = fast.next.next if fast and fast.next else None
            slow = slow.next if slow else None
        
        return fast and slow and fast == slow
        