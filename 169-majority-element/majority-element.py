class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        r,f = nums[0] , 1
        for i in range(1,len(nums)):
            if nums[i]==r:
                f += 1
            else:
                f -= 1
                if f == 0:
                    r, f = nums[i], 1
        return r

