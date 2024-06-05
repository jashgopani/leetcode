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
        if p.val <= q.val:
            res = ListNode(p.val)
            p = p.next
        else:
            res = ListNode(q.val)
            q = q.next
        r = res
        # print(p.val,q.val,r.val)
        while p or q:
            if p and q:
                r.next = ListNode(min(p.val,q.val))
                r = r.next
                if p.val <= q.val:
                    p = p.next
                else:
                    q = q.next
            elif p and not q:
                r.next = p
                break
            else:
                r.next = q
                break
        return res
