class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxL = 0
        charset = set()
        l = 0
        for r in range(len(s)):
            while s[r] in charset:
                charset.remove(s[l])
                l+=1
            charset.add(s[r])
            maxL = max(maxL, r-l+1)

        return maxL
        