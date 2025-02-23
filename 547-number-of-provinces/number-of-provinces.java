class Solution {
    public int findCircleNum(int[][] isConnected) {
        //using union find algo to solve this
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n]; //size of each component

        //initially every component is its own parent and size of each component is 1
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int provinces = n;
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(i!=j && isConnected[i][j] == 1){
                    //union
                    provinces -= union(i,j,parent,rank);
                }
            }
        }

        return provinces;
    }

    public int find(int n, int[] parent){
        int res = n;
        while(res != parent[res]){
            parent[res] = parent[parent[res]]; //path compression optimization
            res = parent[res];
        }
        return res;
    }

    public int union(int n1, int n2, int[] parent, int[] rank){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if(p1==p2){
            return 0; //same parent so no need to merge
        }
        
        if(p1 > p2){
            //merge p2 into p1
            parent[p2] = p1;
            rank[p1]+=rank[p2]; //add size of p2 to p1
        }else{
            parent[p1] = p2;
            rank[p2]+=rank[p1]; //add size of p1 to p2
        }

        return 1;
    }
}