class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = Counter(s)
        evenCount, oddCount = 0,0
        for c,f in freq.items():
            if f % 2 == 0:
                evenCount += f
            else:
                evenCount += (f-1)
                oddCount += 1

        return evenCount + min(oddCount,1)
        
                
        