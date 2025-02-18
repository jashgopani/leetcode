class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = res.length();

        for(int i=0; i<s.length();i++){
            //check odd length palindromes
            String res1 = helper(i,i, s);
            // int l=i, r=i;
            // while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            //     if(r - l + 1 > resLen){
            //         res = s.substring(l,r+1);
            //         resLen = r - l + 1;
            //     }
            //     l--;
            //     r++;
            // }

            //check even length palindromes
            String res2 = helper(i,i+1,s);
            // l=0; 
            // r=1;
            // while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            //     if(r - l + 1 > resLen){
            //         res = s.substring(l,r+1);
            //         resLen = r - l + 1;
            //     }
            //     l--;
            //     r++;
            // }

            String longRes = res1.length() > res2.length()? res1: res2;
            res = res.length() > longRes.length()? res: longRes;
            resLen = res.length();
        }

        return res;
    }

    public String helper(int l, int r, String s){
        String res = "";
        int resLen = 0;
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            if(r - l + 1 > resLen){
                res = s.substring(l,r+1);
                resLen = r - l + 1;
            }
            l--;
            r++;
        }
        return res;
    }
}