class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int l = 0, r = l+1;
        while(l < r && r < prices.length){
            int buy = prices[l];
            int sell = prices[r];
            int profit = sell - buy;
            ans = Math.max(ans, profit);
            r++;
            // System.out.println(String.format("buy %d, sell %d, ans = %d",buy,sell,ans));
            if(r == prices.length){
                while(l < r && prices[l] >= buy){
                    l++;
                    // System.out.println("\tincrementing l="+l);
                }
                // System.out.println("\tbuy "+prices[l]);
                r = l+1;
            }
        }
        return ans;
    }
}