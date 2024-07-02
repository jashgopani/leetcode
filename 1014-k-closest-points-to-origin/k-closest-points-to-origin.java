class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] res = new int[k][2];
        PriorityQueue<List<Integer>> q = new PriorityQueue<>((List<Integer> p1, List<Integer> p2)->Integer.compare(p1.get(0),p2.get(0)));
        
        for(int i=0;i<n;i++){
            int x = points[i][0], y=points[i][1];
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(x*x+y*y);
            pair.add(i);
            q.add(pair);
        }

        for(int i=0;i<k;i++){
            List<Integer> p = q.poll();
            res[i] = points[p.get(1)];
        }
        return res;
    }
}