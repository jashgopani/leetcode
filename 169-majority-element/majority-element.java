class Solution {
    public int majorityElement(int[] nums) {
        int r = nums[0], f = 1;
        for (int i = 0; i < nums.length; i++) {
            f += (nums[i] == r ? 1 : -1);
            if (f == 0) {
                r = nums[i];
                f = 1;
            }
        }
        return r;
    }
}