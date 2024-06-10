# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l,r, res = 0, n, n
        
        while l<=r:
            m = (l+r)//2
            
            if isBadVersion(m):
                if l==r:
                    return m
                else:
                    res = min(res,m)
                    r = m-1
            else:
                l = m+1
        return res
        