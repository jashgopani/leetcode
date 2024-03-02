class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return optimal(strs);
    }

    public List<List<String>> optimal(String[] strs){
        
        List<List<String>> groups = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            // String key = getCharCountString(s);
            if(!map.containsKey(key)){
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(key,group);
            }else{
                map.get(key).add(s);
            }
        }
        
        for(List<String> l:map.values()){
            groups.add(l);
        }
        return groups;
    }

    public String getCharCountString(String s){
        int[] count = new int[26];
        int a = (int)'a';
        for(char c:s.toCharArray()){
            count[((int)c)-a]+=1;
        }
        return Arrays.toString(count);
    }

    public List<List<String>> bruteForce(String[] strs){
        //O(N^3)
        Set<Integer> grouped = new HashSet<>();
        List<List<String>> groups = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(!grouped.contains(i)){
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(!grouped.contains(j) && isAnagram(strs[i],strs[j])){
                        group.add(strs[j]);
                        grouped.add(j);
                    }
                }
                groups.add(group);
            }
        }
        return groups;    
    }

    public boolean isAnagram(String s, String t) {
        // O(N)
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