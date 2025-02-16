class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int l = 0, r = l+1;
        while(l < r && r < prices.length){
            int profit = prices[r] - prices[l];
            if (profit < 0){
                l = r++;
            }else{
                r++;
            }
            ans = Math.max(ans,profit);
        }
        return ans;
    }
}