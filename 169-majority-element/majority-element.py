class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        freq = {}
        r,f = nums[0] , 1
        for n in nums:
            freq[n] = freq.get(n,0) + 1
            if freq[n] >= len(nums)//2 and freq[n] > f:
                f = freq[n]
                r = n
        return r

