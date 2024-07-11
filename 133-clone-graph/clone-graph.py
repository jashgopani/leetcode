"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, root: Optional['Node']) -> Optional['Node']:
        clones = dict()

        def clone(node):
            if not node: return None

            if node in clones:
                return clones[node]
            
            copy = Node(node.val)
            clones[node] = copy
            for n in node.neighbors:
                copy.neighbors.append(clone(n))
            return copy
        
        return clone(root)
                    
