class Solution {
    public int countSubstrings(String s) {
            int n=s.length();
            if(n==1) return 1;

            int count = 0;
            
            for(int i=0;i<n;i++){
                //odd palindromes
                count += addPalindromes(i,i,s);
                //even palindromes
                count += addPalindromes(i,i+1,s);
            }
        return count;
    }
    
    public int addPalindromes(int l, int r, String s){
        int count = 0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            String substr = s.substring(l,r+1);
            count++;
            l--;
            r++;
        }
        return count;
    }
}


