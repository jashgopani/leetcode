class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        map = dict()
        for c in s:
            if c not in map:
                map[c] = 0
            map[c] += 1
        for c in t:
            if c in map:
                map[c] -= 1
                if map[c] == 0:
                    del map[c]
        return len(map)==0