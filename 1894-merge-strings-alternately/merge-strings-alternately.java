class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        String longer = n>m?word1:word2;
        int limit = Math.min(word1.length(),word2.length());
        for(int i=0;i<limit;i++){
          sb.append(word1.charAt(i));
          sb.append(word2.charAt(i));
        }
        for(int i=limit;i<longer.length();i++){
          sb.append(longer.charAt(i));
        }
        return sb.toString();
    }
}