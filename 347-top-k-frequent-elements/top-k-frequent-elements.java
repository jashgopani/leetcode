class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for(int i:nums){
            if(freq.containsKey(i)){
                int currFreq = freq.get(i)+1;
                freq.put(i,currFreq);
                maxFreq = Math.max(maxFreq,currFreq);
            }else{
                freq.put(i,1);
                maxFreq = Math.max(maxFreq,1);
            }
        }

        ArrayList[] bucket = new ArrayList[maxFreq+1];
        for(Map.Entry<Integer,Integer> e: freq.entrySet()){
            int f = e.getValue();
            int num = e.getKey();
            if(bucket[f]==null) bucket[f] = new ArrayList<Integer>();

            bucket[f].add(num);
        }
        
        
        int[] ans = new int[k];
        for(int i=maxFreq, c=0;i>=0 || c<k;i--){
            if(bucket[i]!=null){
                for(int n:(ArrayList<Integer>)bucket[i]){
                    if(c < k)
                        ans[c++] = n;
                }

                if(c==k) break;
            }
        }
        return ans;
    }
}