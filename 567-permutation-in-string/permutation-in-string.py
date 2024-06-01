class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        matches = 0
        a1, a2 = [0] * 26, [0] * 26

        for i in range(len(s1)):
            a1[self.toInt(s1[i])] += 1
            a2[self.toInt(s2[i])] += 1

        for i in range(len(a1)):
            matches += (1 if a1[i] == a2[i] else 0)

        l = 0
        # print('window =',s2[0:len(s1)])
        # print('matches =',matches)
        for r in range(len(s1), len(s2)):
            if matches == 26:
                return True
            # print('window = [',s2[l+1:r+1],']','removed:',s2[l],'added:',s2[r])
            
            # element removed from left side
            i = self.toInt(s2[l])
            a2[i] -= 1
            if a1[i] == a2[i]:
                # print('l: created match')
                matches += 1
            elif a1[i] - 1 == a2[i]:
                # print('l: created mismatch')
                matches -= 1

            # element added from right side
            i = self.toInt(s2[r])
            a2[i] += 1
            if a1[i] == a2[i]:
                # print('r: created match')
                matches += 1
            elif a1[i] + 1 == a2[i]:
                # print('r: created mismatch')
                matches -= 1


            # print('matches =',matches)
            l += 1

        return matches == 26

    def toInt(self, c: str) -> int:
        return ord(c) - ord("a")
