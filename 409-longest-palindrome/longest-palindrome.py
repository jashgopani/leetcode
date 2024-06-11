class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = Counter(s)
        evenCount, oddCount = 0,0
        # print(freq)
        for c,f in freq.items():
            if f % 2 == 0:
                evenCount += f
            elif f == 1:
                oddCount += 1
            else:
                evenCount += (f-1)
                oddCount += 1
        # print('even',evenCount,'odd',oddCount)
        res = evenCount
        res += (1 if oddCount >= 1 else 0)
        return res
        
                
        