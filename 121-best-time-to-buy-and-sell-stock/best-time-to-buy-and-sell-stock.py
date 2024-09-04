class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i,j = 0,1
        n = len(prices)
        res = 0
        while (i<j and j<n):
            profit=prices[j]-prices[i]
            if profit < 0:
                i=j
                j+=1
                res = max(res,profit)
            else:
                res = max(res,profit)
                j+=1
        return res
        
        
        