class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
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
        