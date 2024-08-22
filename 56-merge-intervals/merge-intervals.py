class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        prev = None
        intervals = sorted(intervals, key=lambda x:x[0])
        for start,end in intervals:
            if(prev):
                pstart, pend = prev
                # completely before
                if end < pstart:
                    res.append([start,end])
                # completely after
                elif start > pend:
                    res.append(prev)
                    prev = [start,end]
                else:
                    prev = [min(start,pstart),max(end,pend)]
            else:
                prev = [start,end]
        res.append(prev)
        return res