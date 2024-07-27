class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        visited = set()
        queue = collections.deque()
        time = -1
        first_tuples = []
        oranges = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(0,m):
            for j in range(0,n):
                oranges+= 1 if grid[i][j] > 0 else 0
                if grid[i][j]==2: 
                    first_tuples.append((i,j))
                    visited.add((i,j))
        queue.append(first_tuples)
        delI = [-1,0,1,0]
        delJ = [0,1,0,-1]

        while queue:
            time += 1
            rottens = queue.pop()
            next_tuples = []
            for r in rottens:
                i,j = r
                for d in range(0,4):
                    newI, newJ = i+delI[d], j+delJ[d]
                    if newI >= 0 and newI < m and newJ >= 0 and newJ < n:
                        if grid[newI][newJ]>0 and (newI,newJ) not in visited:
                            next_tuples.append((newI,newJ))
                            visited.add((newI,newJ))
            if next_tuples:
                queue.append(next_tuples)
        return time if len(visited)==oranges else -1
                