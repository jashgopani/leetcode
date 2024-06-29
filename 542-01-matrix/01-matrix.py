class Solution:
    
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        visited = [[False]*n for i in range(m)]
        res = [[0]*n for i in range(m)]
        q = []
        delRow = [-1,0,1,0]
        delCol = [0,1,0,-1]
        # comment = ['t','r','b','l']

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    visited[i][j]=True
                    q.append((i,j,0))
                    # print('+q:',q[-1])
        
        while len(q)>0:
            i, j, dist = q.pop(0)
            for d in range(4):
                nrow = delRow[d]+i
                ncol = delCol[d]+j
                if nrow>=0 and nrow<m and ncol>=0 and ncol<n and not visited[nrow][ncol]:
                    # print('bfs:',comment[d], i,j,' = ',dist+1)
                    visited[nrow][ncol] = True
                    res[nrow][ncol] = dist+1
                    q.append((nrow,ncol,dist+1))
        
        return res




    