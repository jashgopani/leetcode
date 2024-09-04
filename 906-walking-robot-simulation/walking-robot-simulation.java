class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer,Set<Integer>> obsMap = new HashMap<>();
        for(int[] p: obstacles){
            obsMap.putIfAbsent(p[0],new HashSet<>());
            obsMap.get(p[0]).add(p[1]);
        }

        int x=0, y=0, cd=1;
        int[][] directions = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        int res = 0;
        for (int c:commands){
            if (c==-1){
                cd = ((cd - 1)+4)%4;
            }else if (c==-2){
                cd = (cd + 1)%4;
            }else{
                int[] d = directions[cd];
                for (int i=1;i<c+1;i++){
                    int newX = d[0]==0?x:(x + d[0]);
                    int newY = d[1]==0?y:(y + d[1]);
                    if (obsMap.containsKey(newX) && obsMap.get(newX).contains(newY)){
                        break;
                    }else{
                        x=newX;
                        y=newY;
                        res = Math.max(res,x*x + y*y);
                    }
                }
            }
        }
        return res;
    }
}