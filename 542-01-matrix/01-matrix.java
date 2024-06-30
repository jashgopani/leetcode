class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<List<Integer>> q = new ArrayDeque<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    l.add(0);
                    q.add(l);
                }
            }
        }

        int[] di = new int[]{-1,0,1,0};
        int[] dj = new int[]{0,1,0,-1};
        while(q.iterator().hasNext()){
            List<Integer> tuple = q.poll();
            int i = tuple.get(0);
            int j = tuple.get(1);
            int dist = tuple.get(2);

            for(int d=0;d<4;d++){
                int nrow = i+di[d];
                int ncol = j+dj[d];

                if(inRange(nrow,0,m) && inRange(ncol,0,n) && !visited[nrow][ncol]){
                    res[nrow][ncol] = dist+1;
                    List<Integer> l = new ArrayList<>();
                    l.add(nrow);
                    l.add(ncol);
                    l.add(dist+1);
                    q.add(l);
                    visited[nrow][ncol] = true;
                }
            }
        }

        return res;

    }

    public boolean inRange(int n,int left, int right){
        return n>=left && n<right;
    }
}