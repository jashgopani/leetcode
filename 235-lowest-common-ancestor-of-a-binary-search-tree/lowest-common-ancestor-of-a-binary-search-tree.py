# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root and p and q:
            if root.left and root.right and ((root.left.val == p.val and root.right.val == q.val) or (root.val==p.val and root.right and root.right.val == q.val) or (root.val == q.val and root.left and root.left.val == p.val)):
                return root
            elif p.val < root.val and q.val < root.val and root.left:
                return self.lowestCommonAncestor(root.left,p,q)
            elif p.val > root.val and q.val > root.val and root.right:
                return self.lowestCommonAncestor(root.right,p,q)
            else:
                return root
        
        return None
        
