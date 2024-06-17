class Solution:
    def addBinary(self, a: str, b: str) -> str:
        op1, op2 = 0, 0
        for d in a:
            op1 = op1*2 + int(d)
        
        for d in b:
            op2 = op2*2 + int(d)
        
        ans = op1+op2
        res = ""
        while ans > 0:
            res = str(ans % 2) + res
            ans = ans // 2
        return res if res else "0"
            
        