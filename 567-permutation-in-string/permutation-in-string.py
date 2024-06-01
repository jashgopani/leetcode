class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        size = len(s1)
        if size > len(s2):
            return False
        
        charMap = {}
        for i in range(size):
            if s1[i] not in charMap:
                charMap[s1[i]] = 0
            charMap[s1[i]] += 1
        # print("s1",s1,"size",size,"charMap",charMap)
        for i in range(len(s2)-size+1):
            tempMap = charMap.copy()
            # print(f"checking: {s2[i:i+size]}")
            for j in range(i, i+size):
                # print(f"\t{s2[j]} in {tempMap} ? {s2[j] in tempMap}")
                if s2[j] in tempMap:
                    tempMap[s2[j]] -= 1
                    if tempMap[s2[j]]==0:
                        del tempMap[s2[j]]
                elif s2[j] not in tempMap and len(tempMap) > 0:
                    # print(f"\ttempMap not empty, breaking")
                    break

                if not tempMap:
                    return True
                    
        return False
        
        