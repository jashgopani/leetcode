class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [i if i<3 else -1 for i in range(0,n+1)]
        return self.countWays(n,dp)
    
    def countWays(self, n, dp):
        if n>2 and dp[n]==-1:
            dp[n] = self.countWays(n-1,dp)+ self.countWays(n-2,dp)
        
        return dp[n]

        