class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        freq = dict()
        for w in s1.split():
            if w not in freq:
                freq[w] = 0
            freq[w] += 1
        for w in s2.split():
            if w not in freq:
                freq[w] = 0
            freq[w] += 1
        res = []
        for key,value in freq.items():
            if value == 1:
                res.append(key)
        return res