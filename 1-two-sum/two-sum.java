class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> pos = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            pos.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(pos.containsKey(temp) && pos.get(temp)!=i){
                return new int[]{pos.get(temp),i};
            }
        }

        return new int[]{-1,-1};
    }

}