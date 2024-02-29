class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        Map<Character,Integer> charCount = new HashMap<>();
        for(char c:s.toCharArray()){
            if(charCount.containsKey(c)){
                charCount.put(c,charCount.get(c)+1);
            }else{
                charCount.put(c,1);
            }
        }

        for(char c:t.toCharArray()){
            if(charCount.containsKey(c)){
                charCount.put(c,charCount.get(c)-1);
                if(charCount.get(c)==0){
                    charCount.remove(c);
                }
            }else{
                return false;
            }
        }

        return charCount.isEmpty();
    }
}