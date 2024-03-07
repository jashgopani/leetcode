class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroIndex = -1;
        boolean allZeros = false;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && zeroIndex==-1){
                zeroIndex=i;
            }else if(nums[i]==0 && zeroIndex!=-1){
                allZeros = true;        
            }else{
                product*=nums[i];
            }
        }

        int[] res = new int[nums.length];
        if(!allZeros && zeroIndex==-1){
            for(int i=0;i<res.length;i++){
                res[i]=(product/nums[i]);
            }
        }else if(!allZeros && zeroIndex!=-1){
            res[zeroIndex] = product;
        }
        
        return res;
    }
}