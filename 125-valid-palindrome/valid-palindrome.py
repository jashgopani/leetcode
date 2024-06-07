class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleanStr = ""
        for c in s:
            if c.isalnum():
                cleanStr += c.lower()
        return cleanStr == cleanStr[::-1]