class Solution:
    def longestPalindrome(self, s: str) -> int:
        odd = 0
        counter = {}
        for c in s:
            counter[c] = counter.get(c,0)+1
            odd += (1 if counter[c]%2==1 else -1)
        return len(s) - max(0, odd-1)
            
        
                
        