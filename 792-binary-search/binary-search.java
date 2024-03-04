class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==1)return target==nums[0]?0:-1;

        for(int left=0, right=n-1;left<=right;){
          if(!(left > -1 && left<n && right > -1 && right < n)) return -1;
          int mid = (left+right)/2;
          int val = nums[mid];
          if(val==target){
            return mid;
          }else if(target < val){
            right = mid-1;
          }else{
            left = mid+1;
          }
        }
        return -1;
    }
}