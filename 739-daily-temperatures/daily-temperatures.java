class Solution {
    class Pair{
        int k,v;
        public Pair(int k,int v){
            this.k = k;
            this.v = v;
        }
        public int getKey(){
            return k;
        }
        public int getValue(){
            return v;
        }
    }
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<temp.length;i++){
            int t = temp[i];
            while(!stack.empty() && t>stack.peek().getValue()){
                Pair p = stack.pop();
                ans[p.getKey()] = i-p.getKey();
            }
            stack.push(new Pair(i,t));
        }
        return ans;
    }

    public int[] bruteForce(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[i]<temperatures[j]){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }
}