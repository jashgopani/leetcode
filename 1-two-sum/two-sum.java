class Solution {
    public int[] twoSum(int[] nums, int target) {
        return optimal(nums,target);
    }

    public int[] optimal(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                return new int[]{map.get(target-nums[i]),i};
            }
        }
        return new int[]{0,1}; 
    }

    public int[] bruteForce(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,1};
    }
}