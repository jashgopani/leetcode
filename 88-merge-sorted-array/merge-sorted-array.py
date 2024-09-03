class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i, j, t = m-1, n-1, m+n-1

        while j > -1:
            if i > -1:
                if nums1[i] > nums2[j]:
                    nums1[t] = nums1[i]
                    i -= 1
                else:
                    nums1[t] = nums2[j]
                    j -= 1
            else:
                nums1[t] = nums2[j]
                j -= 1
            t -= 1

            
        