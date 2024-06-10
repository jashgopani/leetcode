class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        str1 = Counter(ransomNote)
        str2 = Counter(magazine)
        if str1 & str2 == str1:
            return True
        return False