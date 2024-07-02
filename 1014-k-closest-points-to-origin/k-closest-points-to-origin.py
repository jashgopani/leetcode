class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        n = len(points)
        dist = [0]*n
        for i in range(n):
            x,y = points[i]
            dist[i] = (math.sqrt(x*x+y*y),i)
        
        dist.sort(key=lambda p:p[0])
        return list(map(lambda x:points[x[1]], dist[0:k]))
