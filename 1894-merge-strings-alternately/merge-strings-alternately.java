class Solution {
    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1,len2);
        StringBuilder b = new StringBuilder();
        int i=0;
        while(i<len){
            if(i<len1){
                b.append(word1.charAt(i));
            }
            if(i<len2){
                b.append(word2.charAt(i));
            }
            i++;
        }
        if(i<len1){
            b.append(word1.substring(i));
        }else if(i<len2){
            b.append(word2.substring(i));
        }
        return b.toString();
    }
}