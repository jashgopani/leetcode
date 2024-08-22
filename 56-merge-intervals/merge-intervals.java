class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] sortedIntervals = new int[intervals.length][];
        for (int i=0;i<intervals.length;i++){
            sortedIntervals[i] = Arrays.copyOf(intervals[i],intervals[i].length);
        }
        Arrays.sort(sortedIntervals,(a,b)->Integer.compare(a[0],b[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] prev = sortedIntervals[0];

        for(int i=1;i<sortedIntervals.length;i++){
            int[] curr = sortedIntervals[i];
            if (curr[1] < prev[0]){
                res.add(Arrays.copyOf(curr,curr.length));
            }else if(curr[0] > prev[1]){
                res.add(Arrays.copyOf(prev,prev.length));
                prev = curr;
            }else{
                prev = new int[]{Math.min(curr[0],prev[0]), Math.max(curr[1],prev[1])};
            }
        }
        res.add(Arrays.copyOf(prev,prev.length));
        int [][] ans = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}