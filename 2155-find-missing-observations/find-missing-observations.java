class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int msum = 0;
        for (int i:rolls){
            msum+= i;
        }

        int targetSum = mean * (rolls.length+n);
        int leftSum = targetSum - msum;

        int[] res = new int[n];
        if ((leftSum / 6) > n){
            return new int[]{};
        }
        for (int i=0;i<n;i++){
            int q = leftSum / (n-i);
            int r = leftSum % (n-i);
            int v = Math.min(6, Math.max(1, q+r));
            leftSum -= v;
            res[i]=v;
        }
        if (leftSum != 0)
            return new int[]{};
        return res;
    }
}