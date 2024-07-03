class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        Set<Character> set = new HashSet<>();
        for(int l=0,r=0;r<s.length();r++){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l+=1;
            }
            set.add(s.charAt(r));
            maxL = Math.max(maxL, r-l+1);
        }

        return maxL;
    }
}