class Solution {
    public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<>();
        int sum = squaredDigitSum(n);
        history.add(sum);
        System.out.println(sum);
        while(true){
          sum=squaredDigitSum(sum);
          if(sum==1)
            return true;
          else if(history.contains(sum))
            return false;
          history.add(sum);
          System.out.println(sum);
        }
    }

    public int squaredDigitSum(int n){
      if(n<10)return n*n;
      if(n==10)return 1;

      int square = 0;
      while(n!=0){
        int d = n%10;
        square+=(d*d);
        n/=10;
      }
      return square;
    }
}