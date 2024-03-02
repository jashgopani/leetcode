class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int n = word1.length();
        int m = word2.length();
        String longer = n>m?word1:word2;
        int limit = Math.min(word1.length(),word2.length());
        for(int i=0;i<longer.length();i++){
          if(i<limit){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
          }else{
            sb.append(longer.charAt(i));
          }
        }
        return sb.toString();
    }
}