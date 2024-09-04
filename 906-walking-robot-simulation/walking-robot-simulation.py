class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        obsMap = dict()
        for x,y in obstacles:
            if x not in obsMap:
                obsMap[x] = set()
            obsMap[x].add(y)
        x,y,theta = 0,0,-90
        direction = [(1,0),(0,1),(-1,0),(0,-1)]
        currDirection = 1
        res = 0
        for c in commands:
            if c==-1:
                # +4 to map the negative value to corresponding direction
                currDirection = ((currDirection - 1)+4)%4
                print(c,"rotate +90",currDirection)
            elif c==-2:
                currDirection = (currDirection + 1) % 4
                print(c,"rotate -90",currDirection)
            else:
                dx,dy = direction[currDirection]
                print(f"dx={dx}, dy={dy}")
                for i in range(1,c+1):
                    newX = x+dx if dx != 0 else x
                    newY = y+dy if dy != 0 else y
                    
                    print(c,f"next: i={i}",newX, newY)
                    if newY not in obsMap.get(newX,set()):
                        x,y = newX, newY
                        res = max(res, x**2 + y**2)
                    else:
                        print("obstacle ahead")
                        break
        return res