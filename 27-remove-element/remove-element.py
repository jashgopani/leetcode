class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        count = 0
        curr = 0
        n = len(nums)
        start,end = 0,n-1
        while start <= end and end>=0 and start<n:
            if nums[start] == val:
                count+=1
                while start<end and nums[end] == val:
                    count += 1
                    end -=1
                if end >= 0: 
                    nums[start],nums[end] = nums[end],nums[start]
                    end -= 1
            start += 1
        return n-count