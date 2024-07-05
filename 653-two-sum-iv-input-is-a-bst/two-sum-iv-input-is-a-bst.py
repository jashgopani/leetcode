# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self,root:Optional[TreeNode], reverse:bool=False):
        self.reverse = reverse
        self.stack = []
        self.pushAll(root)
    
    def next(self):
        curr = self.stack.pop()
        self.pushAll(curr.left if self.reverse else curr.right)
        return curr.val
    
    def hasNext(self):
        return len(self.stack)>0


    def pushAll(self,root:Optional[TreeNode]):
        temp = root
        while temp:
            self.stack.append(temp)
            temp = temp.right if self.reverse else temp.left
        

class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        l, r = BSTIterator(root), BSTIterator(root,True)
        left, right = l.next(), r.next()
        while left < right:
            twoSum = left + right
            if twoSum == k:
                return True
            elif twoSum < k:
                left = l.next()
            else:
                right = r.next()
        return False
        
