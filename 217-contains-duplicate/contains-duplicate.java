class Solution {
    public boolean containsDuplicate(int[] nums) {
        return optimized(nums);
    }

    public boolean optimized(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            if(set.contains(n)){
                return true;
            }else{
                set.add(n);
            }
        }

        return false;
    }

    public boolean bruteForce(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }

        return false;
    }
}