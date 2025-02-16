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
        
        Map<Integer,Integer> isizeMap = new HashMap<>(); //<islandNumber, area>

        int islandNumber = 1; //the first island would be 1
        int ans = 0;//area can be 0

        //counting islands and finding the max area using dfs
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    int isize = dfs(i, j, grid, islandNumber);
                    ans = Math.max(isize,ans);
                    if (isize > 0) {
                        isizeMap.put(islandNumber++,isize);
                    }
                }
            }
        }
        
        //visiting all zeros
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int jointIslandSize = 1;
                    
                    // To avoid adding the area of same island multiple times, incase the current 0 has multiple cells of same islands as neighbours
                    Set<Integer> visitedIslands = new HashSet<>();
                    for(int[] move: moves){
                        int newI = i + move[0];
                        int newJ = j + move[1];

                        if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && visited[newI][newJ]>0 && !visitedIslands.contains(visited[newI][newJ])){
                            int nextIsland = visited[newI][newJ];
                            jointIslandSize += isizeMap.getOrDefault(nextIsland,0);
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
        //base case
        if(visited[i][j] > 0) return 0;

        visited[i][j] = islandNumber; //marking the island as visited and tagging it with the islandNumber in a single line of code!
        
        int n = grid.length;
        int m = grid[0].length;

        int count = 1; //since we visited one cell of this island, the minimum value would be 1
        
        //visiting neighbors of current cell
        for(int[] move: moves){
            int newI = i + move[0];
            int newJ = j + move[1];
        
            if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ]==1){
                count += dfs(newI, newJ, grid, islandNumber);
            }
        }
        return count; //area of the island
    }    
}