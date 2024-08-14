class Solution:
    def romanToInt(self, s: str) -> int:
        mapping = {
            "I":1,
            "V":5,
            "X":10,
            "L":50,
            "C":100,
            "D":500,
            "M":1000
        }
        res = 0
        i = 0
        skipNext = False
        while i<len(s):
            curr = s[i]

            if skipNext:
                skipNext = False
            
            if curr=="I" and i<len(s)-1 and (s[i+1]=="V" or s[i+1]=="X"):
                res += (mapping[s[i+1]]-mapping["I"])
                skipNext = True
            elif curr=="X" and i<len(s)-1 and (s[i+1]=="L" or s[i+1]=="C"):
                res += (mapping[s[i+1]]-mapping["X"])
                skipNext = True
            elif curr=="C" and i<len(s)-1 and (s[i+1]=="D" or s[i+1]=="M"):
                res += (mapping[s[i+1]]-mapping["C"])
                skipNext = True
            else:
                res += mapping[curr]

            # print(f"skip: {skipNext} at {s[i]}")
            i += (2 if skipNext else 1)
        return res


            