# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        return self.dfs(root,[])
    
    def dfs(self, root, res):
        if root:
            if root.left:
                res = self.dfs(root.left,res)
            res.append(root.val)
            if root.right:
                res = self.dfs(root.right,res)
        return res
        