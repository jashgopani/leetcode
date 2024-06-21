# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return max(self.dfs(root))+1 if root else 0
    
    def dfs(self, root):
        if not root: return [0,0]

        left, right = 0, 0
        if root.left:
            left = 1 + max(self.dfs(root.left))
        
        if root.right:
            right = 1 + max(self.dfs(root.right))
        
        return [left, right]

        