class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String,List<String>> freq = new HashMap<>();

        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(freq.containsKey(sorted)){
                freq.get(sorted).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                freq.put(sorted,list);
            }
        }

        for(Map.Entry<String, List<String>> e: freq.entrySet()){
            String key = e.getKey();
            List<String> value = e.getValue();

            ans.add(value);
        }

        return ans;


    }
}