class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> track = new HashMap<>();
        for(char c: magazine.toCharArray()){
            if(!track.containsKey(c)){
                track.put(c,1);
            }else{
                track.put(c,track.get(c)+1);
            }
        }
        for(char c:ransomNote.toCharArray()){
            if(track.containsKey(c)){
                int newCount = track.get(c)-1;
                if(newCount==0) track.remove(c);
                else track.put(c,newCount);
            }else{
                return false;
            }
        }
        return true;
    }
}