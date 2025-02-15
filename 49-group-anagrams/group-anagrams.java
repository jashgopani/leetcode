class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> freq = new HashMap<>();
        for(String s: strs){
            String key = fString(s);
            if(freq.containsKey(key)){
                freq.get(key).add(s);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                freq.put(key,temp);
            }
        }

        for(Map.Entry<String, List<String>> e: freq.entrySet()){
            String key = e.getKey();
            List<String> value = e.getValue();

            ans.add(value);
        }
        return ans;
    }

    public static String fString(String s){
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        String ans = "";
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                ans+=String.format("%d%c,",freq[i],(char)(97+i));
            }
        }
        return ans;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
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