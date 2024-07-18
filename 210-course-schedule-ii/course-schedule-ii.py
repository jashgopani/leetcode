class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        visited = set()
        stack = []
        checked = [False]*numCourses
        
        adj = {i:[] for i in range(numCourses)}
        for a,b in prerequisites:
            adj[a].append(b)
        
        def dfs(a):
            if a in visited: return False
            stack.append(a)
            if adj[a]==[]: return True

            visited.add(a)
            for b in adj[a]:
                if not dfs(b): return False
            visited.remove(a)

            return True
        res = []
        for i in range(numCourses):
            if not checked[i]:
                if not dfs(i): return []
                adj[i]=[]
                while stack:
                    course = stack.pop()
                    if not checked[course]:
                        checked[course]=True
                        res.append(course)
        
        return res
        