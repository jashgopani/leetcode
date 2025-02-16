class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0, r=0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            if(set.contains(s.charAt(r))){
                while(s.charAt(l)!=s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }else{
                set.add(s.charAt(r));
                ans = Math.max(ans, (r-l+1));
            }
            r++;
        }
        return ans;
    }
}