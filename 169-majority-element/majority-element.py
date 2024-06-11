class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        freq = Counter(nums)
        r = nums[0]
        rf = 1
        for n,f in freq.items():
            if f > rf:
                r = n
                rf = f
        return r