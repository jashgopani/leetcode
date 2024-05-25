class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==2:
          return min(nums)
        res = 5001
        left, right = 0, len(nums)-1
        while(left<=right):
          if nums[left] < nums[right]:
            res = min(res,nums[left])
            break
          
          mid = (left+right)//2
          res = min(nums[mid],res)
          if(nums[mid]>=nums[left]):
            left = mid+1
          else:
            right = mid-1
        return res


        