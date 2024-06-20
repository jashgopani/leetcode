# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        return self.maxHeight(root)[2]

    def maxHeight(self, root: Optional[TreeNode])->List[int]:
        if not root:
            return [0,0,0]
        hl, hr, ld, lr= 0,0,0,0 
        if root.left:
            lhl, lhr, ld = self.maxHeight(root.left)
            hl = max(lhl,lhr) + 1
        
        if root.right:
            rhl, rhr, lr = self.maxHeight(root.right)
            hr = max(rhl, rhr) + 1
        
        # third arg is the diameter
        # it will be max of diameter of left, right subtree and subtree from current root
        return [hl, hr, max(hl+hr, ld, lr)]