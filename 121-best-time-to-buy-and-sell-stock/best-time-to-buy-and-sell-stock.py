class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) < 2: return 0
        res = 0
        l,r = 0,1
        while l<r and r < len(prices):
            buy = prices[l]
            sell = prices[r]
            if buy > sell:
                l = r
            else:
                res = max(res,sell-buy)
            r += 1
        return res
        
        