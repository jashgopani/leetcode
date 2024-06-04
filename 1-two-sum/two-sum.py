class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numsDict = {}
        res = [0,1]
        for i,n in enumerate(nums):
            if target-n not in numsDict:
                numsDict[n]=i
            else:
                return [i, numsDict[target-n]]
        
        return res
        