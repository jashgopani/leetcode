class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int ans = Math.max(robHouses(nums,0,n-1), robHouses(nums,1, n));
        return Math.max(nums[0], ans);
    }

    public int robHouses(int[] nums, int start, int end){
        int rob1 = 0, rob2 = 0;
        // rob1: The maximum money that could have been robbed up to the previous house (i.e., before considering the current house).
        // rob2: The maximum money that could have been robbed up to the current house (i.e., including the current house).

        for(int i=start; i<end; i++){
            int maxRob = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = maxRob;
        }

        return rob2;
    }
}