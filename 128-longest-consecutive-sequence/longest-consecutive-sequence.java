class Solution {
    public int longestConsecutive(int[] nums){
        if(nums.length==0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int i:nums){
                set.add(i);
        }
        int ans=1;
        for(int i: set){
            int count = 1;
            if(!set.contains(i-1)){
                for(int j=i+1; set.contains(j); j++){
                    count++;
                }
                ans = Math.max(count,ans);
            }
        }
        return ans;
    }
}