class Solution {
    public int[] productExceptSelf(int[] nums) {
        return optimal(nums);
    }

    public int[] optimal(int[] nums){
        int[] ans = new int[nums.length];

        for(int i=0, product=1;i<ans.length;i++){
            if(i>0) product *= nums[i-1];
            ans[i] = product;
        }

        
        for(int i=ans.length-1, product=1;i>=0;i--){
            if(i < ans.length-1) product*= nums[i+1];
            ans[i] *= product;
        }   

        return ans;
    }


    public int[] bruteForce(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            ans[i] = 1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    ans[i] *= nums[j];
                }
            }
        }

        return ans;
    }
}