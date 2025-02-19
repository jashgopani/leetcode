class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length - 1;
        if(n==0) return 0;

        for(int i=n-2;i>=0;i--){
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0],cost[1]); //because we can start from 0 or 1
    }
}