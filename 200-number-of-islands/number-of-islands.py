class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        queue = collections.deque()
        steps = [[-1,0],[0,1],[1,0],[0,-1]]

        def exists(cell):
            x,y = cell
            return x>=0 and x<len(grid) and y>=0 and y<len(grid[x])
            
        islands = 0
        for i in range(0,len(grid)):
            for j in range(0,len(grid[i])):
                
                if grid[i][j]=="1" and (i,j) not in visited:
                    islands+=1
                    visited.add((i,j))

                    # Start BFS
                    queue.append((i,j))
                    while queue:
                        x,y = queue.pop()

                        for dx,dy in steps:
                            nx, ny = x+dx, y+dy
                            nextCell = (nx,ny)

                            if exists(nextCell) and grid[nx][ny]=="1" and nextCell not in visited:
                                queue.append(nextCell)
                                visited.add(nextCell)
        return islands
