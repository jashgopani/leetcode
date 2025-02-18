class Solution {
    public int rob(int[] nums) {
        int n=nums.length - 1;
        if(n==0) return nums[n];

        int[] dp = new int[n+1];
        dp[n] = nums[n];//base case
        dp[n-1] = Math.max(nums[n-1],dp[n]);

        for(int i=n-2;i>=0;i--){
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }

        return dp[0];
    }
}