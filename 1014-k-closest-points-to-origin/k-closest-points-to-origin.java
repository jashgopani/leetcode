class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] res = new int[k][2];
        
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] p1, int[] p2)->Integer.compare(p1[0],p2[0]));
        
        for(int i=0;i<n;i++){
            int x = points[i][0], y=points[i][1];
            int[] pair = new int[]{x*x+y*y,i};
            q.add(pair);
        }

        for(int i=0;i<k;i++){
            int[] p = q.poll();
            res[i] = points[p[1]];
        }
        return res;
    }
}