class Solution {
    public boolean isValidSudoku(char[][] board) {
        return optimized(board);
    }
    
    public boolean bruteForce(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    System.out.printf("Checking: (%d,%d)\n",i,j);
                    
                    //check in same row
                    for(int y=0;y<board[i].length;y++){
                        if(j!=y && board[i][j]==board[i][y]){
                            System.out.printf("\tSame row entry @ (%d,%d)\n",i,y);
                            return false;
                        }
                    }
                    
                    //check in same col
                    for(int x=0;x<board.length;x++){
                        if(i!=x && board[i][j]==board[x][j]){
                            System.out.printf("\tSame col entry @ (%d,%d)\n",x,j);
                            return false;
                        }
                    }

                    //check subgrid
                    int si = (i/3)*3;
                    int sj = (j/3)*3;
                    System.out.printf("\t Subgrid :: (%d,%d)\n",si,sj);
                    for(int p=si;p<(si+3);p++){
                        for(int q=sj;q<(sj+3);q++){
                            if(p!=i && q!=j && board[p][q]==board[i][j]){
                                System.out.printf("\t\tSame subgrid entry @ (%d,%d)\n",p,q);
                                return false;
                            }
                        }
                    }
                }

            }
        }

        return true;
    }

    public boolean optimized(char[][] board){
        HashMap<Integer,Set<Character>> rowMap = new HashMap<>();
        HashMap<Integer,Set<Character>> colMap = new HashMap<>();
        HashMap<String,Set<Character>> sgMap = new HashMap<>();
        
        for(int i=0;i<board.length;i++){
            rowMap.putIfAbsent(i,new HashSet<>());
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    int sgTop = (i/3);
                    int sgLeft = (j/3);
                    String sgKey = String.format("%d%d",sgTop,sgLeft);

                    colMap.putIfAbsent(j,new HashSet<>());
                    sgMap.putIfAbsent(sgKey,new HashSet<>());

                    char currentValue = board[i][j];

                    if(rowMap.get(i).contains(currentValue)
                        || colMap.get(j).contains(currentValue)
                        || sgMap.get(sgKey).contains(currentValue)){
                        return false;
                    }
                    
                    rowMap.get(i).add(currentValue);
                    colMap.get(j).add(currentValue);
                    sgMap.get(sgKey).add(currentValue);
                    
                    
                }
            }
        }

        return true;
    }

}