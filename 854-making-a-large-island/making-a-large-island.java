class Solution {
    static int[][] moves = new int[][]{
        {-1, 0},//top
        {0, 1}, //right
        {1, 0}, //bottom
        {0, -1} //left
    };
    static int[][] visited;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited  = new int[n][m];
        
        Map<Integer,Integer> isizeMap = new HashMap<>();

        int islandNumber = 1;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    int isize = dfs(i, j, grid, islandNumber);
                    ans = Math.max(isize,ans);
                    if (isize > 0) {
                        // System.out.println("i="+i+" j="+j+" islandNumber="+islandNumber);
                        isizeMap.put(islandNumber++,isize);
                    }
                }
            }
        }
        
        // System.out.println("isizeMap = "+isizeMap);
        // System.out.println("Visited islands");
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(visited[i][j]+"\t");
        //     }
        //     System.out.println();
        // }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int jointIslandSize = 1;
                    Set<Integer> visitedIslands = new HashSet<>();
                    for(int[] move: moves){
                        int newI = i + move[0];
                        int newJ = j + move[1];
                        if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && visited[newI][newJ]>0 && !visitedIslands.contains(visited[newI][newJ])){
                            int nextIsland = visited[newI][newJ];
                            jointIslandSize += isizeMap.getOrDefault(nextIsland,0);
                            // System.out.println(String.format("%d,%d surrounded by island #%d | jointIslandSize = %d",i,j,nextIsland, jointIslandSize));
                            visitedIslands.add(nextIsland);
                            
                        }
                    }
                    ans = Math.max(jointIslandSize, ans);
                }
            }
        }
        return ans;        
    }

    public int dfs(int i, int j, int[][] grid, int islandNumber){
        if(visited[i][j] > 0) return 0;

        visited[i][j] = islandNumber;
        // System.out.println(String.format("Currently at [%d,%d]",i,j));
        
        int n = grid.length;
        int m = grid[0].length;

        int count = 1;
        for(int[] move: moves){
            int newI = i + move[0];
            int newJ = j + move[1];
            
            if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ]==1){
                // System.out.println("\tvalid neighbour = "+newI+","+newJ);
                count += dfs(newI, newJ, grid, islandNumber);
            }
        }
        // System.out.println(String.format("\t\t%d, %d, %d", i,j, count));
        return count;
    }    
}