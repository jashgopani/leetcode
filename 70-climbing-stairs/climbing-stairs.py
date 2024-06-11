class Solution:
    def climbStairs(self, n: int) -> int:
        first, second = 1, 1
        for i in range(n-1):
            temp = second
            # first will become second for i+1
            second = first
            first = first + temp
        return first

        