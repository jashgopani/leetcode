class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> freq = new HashMap<>();
        for(String s:s1.split(" ")){
            freq.putIfAbsent(s,0);
            freq.put(s,freq.get(s)+1);
        }
        for(String s:s2.split(" ")){
            freq.putIfAbsent(s,0);
            freq.put(s,freq.get(s)+1);
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> e: freq.entrySet()){
            if (e.getValue()==1){
                res.add(e.getKey());
            }
        }
        String[] uncommonWords = new String[res.size()];
        for (int i=0;i<res.size();i++){
            uncommonWords[i]=res.get(i);
        }
        return uncommonWords;
    }
}