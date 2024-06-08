class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,r = 0, len(nums)-1
        while l<=r:
            m = (l+r)//2
            if l==r:
                return m if target == nums[m] else -1
            if target == nums[m]:
                return m
            elif target < nums[m]:
                r = m-1
            else:
                l = m+1
        return -1