class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int max = Integer.MIN_VALUE;
      for(int p:piles){
        max = Math.max(p,max);
      }
      int n = piles.length;
      int left = 1, right = max;
      int k = left;
      int speed = max;

      while(left<=right && k>0){
        k = ((left+right)/2);
        long time = getEatingTime(k,piles);
        if(time <= h){
          speed = Math.min(speed,k);
          right = k-1;
        }else{
          left = k+1;
        }
      }

      return speed;
    }

    public long getEatingTime(double speed,int[] piles){
      long time = 0;
      for(int p:piles){
        int t = (int)Math.max(1,Math.ceil(p/speed)); 
        time+=t;
      }
      return time;
    }
}