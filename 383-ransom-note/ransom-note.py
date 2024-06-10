class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        mDict = {}
        for c in magazine:
            mDict[c] = mDict.get(c,0)+1
        
        for c in ransomNote:
            if c in mDict:
                mDict[c] -= 1
                if mDict[c]==0:
                    del mDict[c]
            else:
                return False
        
        return True