# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1: return list2
        if not list2: return list1

        p,q = list1, list2
        res = None
        if p.val < q.val:
            res = p
            p = p.next
        else:
            res = q
            q = q.next
        r = res
        while p or q:
            if p and q:
                if p.val < q.val:
                    r.next = p
                    p = p.next
                else:
                    r.next = q
                    q = q.next
                r = r.next
            elif p and not q:
                r.next = p
                return res
            else:
                r.next = q
                return res
        return res
