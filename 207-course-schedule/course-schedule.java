class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        for(int[] edge: prerequisites){
            int a = edge[0];
            int b = edge[1];

            if(!adjList.containsKey(a)){
                adjList.put(a,new HashSet<>());
            }

            adjList.get(a).add(b);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> processed = new HashSet<>();

        for(int n: adjList.keySet()){
            if(isCyclic(n, adjList, visited, processed)) return false;
        }

        return true;

    }

    public boolean isCyclic(int i, Map<Integer, Set<Integer>> adjList, Set<Integer> visited, Set<Integer> processed){
        if(processed.contains(i)) return true;
        if(visited.contains(i)) return false;

        processed.add(i);
        for(int n: adjList.getOrDefault(i, new HashSet<>())){
            if(isCyclic(n,adjList,visited,processed)) return true;
        }
        processed.remove(i);
        visited.add(i);

        return false;
    }
}