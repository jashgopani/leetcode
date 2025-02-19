class Solution {
    final static int moves[][] = {
        {-1,0},
        {0,1},
        {1,0},
        {0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int maxArea = 0;

        for(int i=0;i < n; i++){
            for(int j=0; j<m; j++){
                maxArea = Math.max(maxArea, dfs(i,j,grid,visited));
            }
        }

        return maxArea;
    }

    public int dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(visited[i][j] || grid[i][j]==0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        int area = 1;

        visited[i][j] = true;

        for(int move[]: moves){
            int newI = i+move[0];
            int newJ = j+move[1];

            if(newI >= 0 && newI < n && newJ >= 0 && newJ < m){
                area += dfs(newI, newJ, grid, visited);
            }
        }

        return area;
    }
}