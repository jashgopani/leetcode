class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0, j=n-1;i<m && i>-1 && j<n && j>-1;){
          int val = mat[i][j];
          // System.out.printf("mat[%d][%d] = %d\n",i,j,val);
          if(target==val){
            return true;
          }else if(target < val){
            n = n-1;
            j = j-1;
          }else{
            i = i+1;
          }
        }
        return false;
    }
}