class Solution:
    def addBinary(self, a: str, b: str) -> str:
        ia, ib = len(a)-1, len(b)-1
        c = 0

        res = ""
        while ia>=0 or ib>=0:
            s = c
            if ia>=0:
                s+= (ord(a[ia]) - ord('0'))
                ia -= 1
            
            if ib>=0:
                s+= (ord(b[ib]) - ord('0'))
                ib -= 1
            
            if s == 0:
                res = "0"+res
                c = 0
            elif s==1:
                res = "1"+res
                c = 0
            elif s==2:
                res = "0"+res
                c = 1
            elif s==3:
                res = "1"+res
                c = 1
            
        if c==1 or len(res)==0:
            res = str(c) + res
        return res
            
        