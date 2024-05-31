class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxL = 0
        for i in range(0, len(s)):
            # print(f'starting new iteration: {maxL}')
            letters = {s[i]}
            maxL = max(maxL,1)
            # print(i,s[i])
            for j in range(i+1, len(s)):
                # print(j, s[j])
                if s[j] in letters:
                    break
                else:
                    letters.add(s[j])
                    maxL = max(maxL, j-i+1) 
                
                if j==len(s)-1:
                    return maxL
        return maxL
        