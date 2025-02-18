class Solution {
    public int countSubstrings(String s) {
            int n=s.length();
            if(n==1) return 1;

            List<String> set = new ArrayList<>();
            int count = 0;
            
            for(int i=0;i<n;i++){
                //odd palindromes
                count += addPalindromes(i,i,s,set);
                //even palindromes
                count += addPalindromes(i,i+1,s,set);
            }
        // return set.size();
        return count;
    }
    
    public int addPalindromes(int l, int r, String s, List<String> set){
        int count = 0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            String substr = s.substring(l,r+1);
            // if(!set.contains(substr)){
                // set.add(substr);
                count++;
            // }
            l--;
            r++;
        }
        return count;
    }
}


