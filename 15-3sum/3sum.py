class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        for i in range(len(nums)):
            a = nums[i]
            if i>0 and nums[i-1]==a:
                continue
            else:
                l,r = i+1, len(nums)-1
                while l < r:
                    # print(l,r, nums)
                    b,c = nums[l], nums[r]
                    threeSum = a+b+c
                    if threeSum==0:
                        res.append([a,b,c])
                        while l<r and nums[l]==b:
                            l+=1
                    elif threeSum < 0:
                        l+=1
                    else:
                        r-=1
        return res
                