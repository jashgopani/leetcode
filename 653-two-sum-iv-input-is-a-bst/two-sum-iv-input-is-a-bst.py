# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        nums = []

        def inorder(r):
            if r:
                if r.left:
                    inorder(r.left)
                nums.append(r.val)
                if r.right:
                    inorder(r.right)
        
        inorder(root)
        l, r = 0, len(nums)-1
        while l<r:
            twoSum = nums[l]+nums[r]
            if twoSum == k:
                return True
            elif twoSum < k:
                l+=1
            else:
                r-=1
        return False