class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()){
            int ascii = (int)c;
            if(inRange(ascii,'a','z') || inRange(ascii,'0','9')){
                sb.append(c);
            }
        }
        for(int l=0, r=sb.length()-1;l<=r;l++, r--){
            if(!(sb.charAt(l)==sb.charAt(r)))return false;
        }
        return true;
    }

    public boolean inRange(int x, int l, int r){
        return x >= l && x <= r;
    }
}