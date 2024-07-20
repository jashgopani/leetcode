class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            String s1 = words[i];
            for(int j=i+1;j<words.length;j++){
                String s2 = words[j];
                if (s1.length()<=s2.length()){
                    if (s2.startsWith(s1) && s2.endsWith(s1)) count++;
                }
            }
        }
        return count;
    }
}