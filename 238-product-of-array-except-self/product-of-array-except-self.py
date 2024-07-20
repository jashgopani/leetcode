class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zeros = 0
        prod = 1
        for i in range(0,len(nums)):
            n = nums[i]
            if n==0:
                zeros+=1
            else:
                prod *= n

        res = [0]*len(nums)
        if zeros <= 1:
            for i in range(0,len(nums)):
                if zeros == 1:
                    if nums[i]==0:
                        res[i] = prod
                else:
                    res[i] = int(prod/nums[i])
        return res

        

        