# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def check(root,head):
            
            if not head:
                return True
            
            if not root:
                return False
            
            print("\tcheck: ",root.val,"",head.val)
            if root.val==head.val:
                return check(root.left,head.next) or check(root.right,head.next)
            
            print("\tcheck: returning False")
            return False
        
        def dfs(root):
            if not root:
                return False
            
            print("dfs @ ",root.val)
            if root.val==head.val:
                if check(root,head):
                    return True
            
            return dfs(root.left) or dfs(root.right)
        
        return dfs(root)