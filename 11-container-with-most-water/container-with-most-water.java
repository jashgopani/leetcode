class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, maxArea = 0;
        while(l<r){
            int h = Math.min(height[l],height[r]);
            int w = r-l;
            int area = w*h;
            maxArea = Math.max(area,maxArea);

            if(height[l] >= height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}