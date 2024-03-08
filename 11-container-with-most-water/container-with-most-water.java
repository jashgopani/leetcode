class Solution {
    public int maxArea(int[] height) {
        return optimal(height);
    }

    public int bruteForce(int[] height){
        int area = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int y = Math.min(height[i],height[j]);
                int x = Math.abs(i-j);
                area = Math.max(area,x*y);
            }
        }
        return area;
    }

    public int optimal(int[] height){
        int max = 0;
        for(int l=0,r=height.length-1;l<r;){
            int area = (r-l)*Math.min(height[l],height[r]);
            max = Math.max(area,max);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}