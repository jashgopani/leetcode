class Solution {
    public int trap(int[] height){
        int n = height.length;
        int maxL = height[0];
        int maxR = height[n-1];
        int trappedWater = 0;
        int i=0, j=n-1;
        while(i<j){
            if(maxL <= maxR){
                i++;
                trappedWater += Math.max(0,maxL - height[i]);
                maxL = Math.max(maxL, height[i]);
            }else{
                j--;
                trappedWater+= Math.max(0,maxR - height[j]);
                maxR = Math.max(maxR, height[j]);
            }
        }
        return trappedWater;
    }
    public int trap_linearmemory(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // max height at before and after start and end is 0 respectively
        left[0] = right[n-1]=0;

        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            left[i] = Math.max(height[i-1], left[i - 1]);
            right[j] = Math.max(height[j+1], right[j + 1]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            totalWater+=(Math.max(0,min-height[i]));
        }
        return totalWater;
    }

}