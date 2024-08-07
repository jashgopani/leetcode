class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums)-1
        while l<r:
            twoSum = nums[l]+nums[r]
            if twoSum == target:
                return [l+1,r+1]
            elif twoSum < target:
                l+=1
            else:
                r-=1
        return None