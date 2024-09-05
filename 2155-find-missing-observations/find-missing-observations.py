class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        msum = sum(rolls)
        m = len(rolls)
        targetSum = mean * (m+n)
        leftSum = targetSum - msum
        
        res = []
        for i in range(n):
            v = min(6,max(1,(leftSum // (n-i)) + (leftSum % (n-i))))
            # print(leftSum,v)
            leftSum -= v
            res.append(v)
        if leftSum!=0:
            return []
        return res