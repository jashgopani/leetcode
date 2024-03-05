class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
      return bs2d(mat,target);
    }
    public boolean searchMatrix2d(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0, j=n-1;i<m && i>-1 && j<n && j>-1;){
          int val = mat[i][j];
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

    public boolean bs2d(int[][] mat, int target){
        int n = mat.length * mat[0].length;
        if(n==1)return target==mat[0][0];
        for(int left=0, right=n-1;left<=right;){
          if(!(left > -1 && left<n && right > -1 && right < n)) return false;
          int mid1d = (left+right)/2;
          int[] mid2d = decode(mid1d,mat.length,mat[0].length);
          int m = mid2d[0];
          int n1 = mid2d[1];
          int val = mat[m][n1];
          // System.out.printf("index=%d, decoded=%s, val=%d\n",mid1d,Arrays.toString(mid2d),val);
          if(val==target){
            return true;
          }else if(target < val){
            right = mid1d-1;
          }else{
            left = mid1d+1;
          }
        }
        return false;
    }

    public int[] decode(int index,int rows,int cols){
      int len = rows*cols;
      int m = (index / cols);
      int n = (index) % cols;
      return new int[]{m,n};
    }
}