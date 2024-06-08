class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        delRow = [-1,0,1,0]
        delCol = [0,1,0,-1]
        return self.dfsr(image,sr,sc,color,image[sr][sc],delRow,delCol) if image[sr][sc] != color else image
    
    def bfs(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        target = image[sr][sc]
        if target==color: return image
        queue = [(sr,sc)]
        while queue:
            i, j = queue.pop(0)
            image[i][j] = color

            if i-1 >= 0 and image[i-1][j]==target:
                queue.append((i-1,j)) #top
            if j+1 < len(image[0]) and image[i][j+1]==target:
                queue.append((i,j+1)) #right
            if i+1 < len(image) and image[i+1][j]==target:
                queue.append((i+1,j)) #bottom
            if j-1 >=0 and image[i][j-1]==target:
                queue.append((i,j-1)) #left

        return image
    
    def dfs(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        target = image[sr][sc]
        if target==color: return image
        stack = [(sr,sc)]
        m = len(image)
        n = len(image[0])
        image[sr][sc]=color

        while stack:
            i,j = stack.pop()    
            # top
            for r in range(i-1,-1,-1):
                if image[r][j] == target:
                    image[r][j] = color
                    stack.append((r,j))
                else:
                    break
            
            # right
            for c in range(j+1, n):
                if image[i][c] == target:
                    image[i][c] = color
                    stack.append((i,c))
                else:
                    break

            # bottom
            for r in range(i+1,m):
                if image[r][j] == target:
                    image[r][j] = color
                    stack.append((r,j))
                else:
                    break
            
            # right
            for c in range(j-1, -1,-1):
                if image[i][c] == target:
                    image[i][c] = color
                    stack.append((i,c))
                else:
                    break

        return image
    
    def dfsr(self, image: List[List[int]], sr: int, sc: int, color: int, target: int, delRow: List[int], delCol: List[int]) -> List[List[int]]:
        m,n = len(image), len(image[0])
        image[sr][sc] = color
        for i in range(0,4):
            r = sr + delRow[i]
            c = sc + delCol[i]
            if r>=0 and r<m and c>=0 and c<n and image[r][c]==target:
                self.dfsr(image,r,c,color,target,delRow,delCol)
        return image

        
        