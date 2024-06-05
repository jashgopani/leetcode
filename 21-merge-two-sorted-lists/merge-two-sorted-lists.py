# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, p: Optional[ListNode], q: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        r = dummy
        while p and q:
            if p.val < q.val:
                r.next = p
                p = p.next
            else:
                r.next = q
                q = q.next
            r = r.next
        if p:
            r.next = p
        elif q:
            r.next = q
        return dummy.next
