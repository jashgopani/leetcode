class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int gridSize = 3;

        Map<Integer,Set<Character>> gridMap = new HashMap<>();
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();

        //traverse entire board to fill in the maps
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                char x = board[i][j];
                
                if (x=='.') continue;

                int gridRow = i/gridSize;
                int gridCol = j/gridSize;
                int gridNo = gridSize * gridRow + gridCol;

                gridMap.putIfAbsent(gridNo, new HashSet<>());
                if(gridMap.get(gridNo).contains(x)) return false;
                gridMap.get(gridNo).add(x);

                rowMap.putIfAbsent(i,new HashSet<>());
                if(rowMap.get(i).contains(x)) return false;
                rowMap.get(i).add(x);

                colMap.putIfAbsent(j,new HashSet<>());
                if(colMap.get(j).contains(x)) return false;
                colMap.get(j).add(x);
            }
        }

        return true;
    }
    
   

}