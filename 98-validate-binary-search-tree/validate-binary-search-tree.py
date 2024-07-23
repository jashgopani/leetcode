# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def inorder(root, res):
            if not root: return res

            res = inorder(root.left, res)
            res.append(root.val)
            res = inorder(root.right,res)

            return res
        
        tree = inorder(root,[])
        for i in range(len(tree)-1):
            if tree[i]>=tree[i+1]:return False
        
        return True


        