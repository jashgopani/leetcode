# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        numSet = set()
        numSet.update(nums)

        while head and head.val in numSet:
            head = head.next
        
        temp = head
        while temp:
            while temp.next and temp.next.val in numSet:
                temp.next = temp.next.next if temp.next.next else None
            temp = temp.next

        return head

