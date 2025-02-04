class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        ans = nums[0]
        sum= nums[0]
        r = 0
        while r < len(nums)-1:
            print(r, sum, ans)
            if nums[r+1] <= nums[r]:
                sum=0
            r+=1
            sum += nums[r]
            ans = max(ans, nums[r], sum)
        return ans
        