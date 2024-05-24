class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      Arrays.sort(piles);
      int n = piles.length;
      int left = 1, right = piles[n-1];
      int k = left;
      int speed = piles[n-1];

      while(left<=right && k>0){
        k = ((left+right)/2);
        long time = getEatingTime(k,piles);
        if(time <= h){
          speed = Math.min(speed,k);
          right = k-1;
        }else{
          left = k+1;
        }
        // System.out.println("New> left: "+left+" right: "+right+" Speed: "+speed+" k: "+k);
      }

      return speed;
    }

    public boolean inRange(int x, int l, int r){
      return x>=l && x<=r;
    }

    public long getEatingTime(double speed,int[] piles){
      long time = 0;
      for(int p:piles){
        int t = (int)Math.max(1,Math.ceil(p/speed)); 
        time+=t;
      }

      // System.out.println("Current> Speed: "+speed+" Times: "+times+" Sum: "+time);
      return time;
    }
}