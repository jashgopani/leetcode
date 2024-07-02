class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        n = len(points)
        dist = []
        for i in range(n):
            x,y = points[i]
            dist.append([x*x+y*y,x,y])
        
        heapq.heapify(dist)
        res = []
        while k>0:
            d,x,y = heapq.heappop(dist)
            res.append([x,y])
            k-=1
        return res
