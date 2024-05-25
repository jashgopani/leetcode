class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, r = 0, n-1
        while l>-1 and r<n and l <= r :
          m = (l+r)//2
          mid = nums[m]

          if l==r and mid!=target:
            break

          print(f"checking: ({m} in [{l}, {r}]) -> [{nums[l]},{nums[r]}], mid: {mid}")
          if mid==target:
            return m
          
          if nums[l] < nums[r]:
            print('sorted case, doing normal bs')
            if target > mid:
              print('sorted case, going to right half next')
              l = m+1
            else:
              print('sorted case, going to left half next')
              r = m-1
          elif nums[l] <= mid:
            print('rotated case: mid in left subarray')
            if target < mid:
              if target >= nums[l]:
                r = m-1
              else:
                l = m+1
            else:
              l = m+1
          else:
            print('rotated case: mid in right subarray')
            if target < mid:
              r = m-1
            elif target > nums[r]:
              r = m-1
            else:
              l = m+1
        return -1
            