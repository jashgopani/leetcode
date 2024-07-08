# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        queue = [[0,root]]
        res = []
        while len(queue)>0:
            level, node = queue.pop(0)
            if len(res)==level:
                res.append([])
            res[level].append(node.val)
            if node.left:
                queue.append([level+1,node.left])
            if node.right:
                queue.append([level+1,node.right])
        
        return res

            
        