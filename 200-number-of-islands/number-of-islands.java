class Solution {
    static int[][] moves = new int[][]{
        {-1, 0},//top
        {0, 1}, //right
        {1, 0}, //bottom
        {0, -1} //left
    };
    static boolean[][] visited;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited  = new boolean[n][m];

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!='0'){
                    int isize = dfs(i, j, grid);
                    // System.out.println("isize = "+isize);
                    if (isize > 0) count++;
                }
            }
        }

        return count;
    }

    public int dfs(int i, int j, char[][] grid){
        if(visited[i][j]) return 0;

        visited[i][j] = true;
        
        int n = grid.length;
        int m = grid[0].length;

        int count = 1;
        for(int[] move: moves){
            int newI = i + move[0];
            int newJ = j + move[1];
            if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ]!='0'){
            // System.out.println("\tvalid new point = "+newI+","+newJ);
                count += dfs(newI, newJ, grid);
            }
        }
        // System.out.println(String.format("\t\t%d, %d, %d", i,j, count));
        return count;
    }
}