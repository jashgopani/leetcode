class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int lastOne = -1;
        int count = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                boolean isLeftEmpty = (i==0) || (flowerbed[i-1]==0);
                boolean isRightEmpty = (i==flowerbed.length-1) || (flowerbed[i+1]==0);
                if(isLeftEmpty && isRightEmpty){
                    flowerbed[i]=1;
                    count++;
                }
            }
            if(count>=n)return true;
        }
        return count >= n;
    }
}