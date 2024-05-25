class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, r = 0, n-1
        while l>-1 and r<n and l <= r :
          m = (l+r)//2
          mid = nums[m]

          if l==r and mid!=target:
            break

          if mid==target:
            return m
          
          if nums[l] < nums[r]:
            if target > mid:
              l = m+1
            else:
              r = m-1
          elif nums[l] <= mid:
            if target < mid:
              if target >= nums[l]:
                r = m-1
              else:
                l = m+1
            else:
              l = m+1
          else:
            if target < mid:
              r = m-1
            elif target > nums[r]:
              r = m-1
            else:
              l = m+1
        return -1
            