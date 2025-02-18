class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int ans = Math.max(robHouses(nums,0,n-1), robHouses(nums,1, n));
        return Math.max(nums[0], ans);
    }

    public int robHouses(int[] nums, int start, int end){
        int prev = 0, curr = 0;

        for(int i=start; i<end; i++){
            int maxRob = Math.max(prev+nums[i], curr);
            prev = curr;
            curr = maxRob;
        }

        return curr;
    }
}