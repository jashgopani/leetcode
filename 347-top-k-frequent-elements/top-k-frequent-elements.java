class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));//max heap that's why b first
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            if(freq.containsKey(i)){
                freq.put(i,freq.get(i)+1);
            }else{
                freq.put(i,1);
            }
        }

        for(Map.Entry<Integer,Integer> e: freq.entrySet()){
            pq.add(new int[]{e.getValue(),e.getKey()});//frequency is the main value for priority queue
        }
        
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}