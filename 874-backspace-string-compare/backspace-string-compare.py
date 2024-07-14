class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        n = len(s)-1
        m = len(t)-1
        a, b = [], []
        for c in s:
            if c=="#":
                if a:
                    a.pop()
            else:
                a.append(c)
        for c in t:
            if c=="#":
                if b:
                    b.pop()
            else:
                b.append(c)
    
        return a==b
        