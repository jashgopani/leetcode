# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l,r, res = 1, n+1, n+1
        
        while l<r:
            m = (l+r)//2
            
            if isBadVersion(m):
                res = m
                r = m
            else:
                l = m+1
        return res
        