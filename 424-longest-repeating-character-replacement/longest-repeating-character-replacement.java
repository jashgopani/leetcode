class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int ans = 0;

        int l = 0;
        for(int r=0; r < s.length();r++){
            freq[s.charAt(r)-'A']++;
            if((r-l+1)-Arrays.stream(freq).max().orElseThrow() > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}