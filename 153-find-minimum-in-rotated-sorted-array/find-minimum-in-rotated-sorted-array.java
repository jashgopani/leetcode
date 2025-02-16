class Solution {
    public int findMin(int[] a) {
        int l=0, r=a.length-1;
        while(l <= r){
            int m = l + (r-l)/2;

            if(a[r] > a[l]){
                //normal binary search
                return a[l];
            }else{//detect which sub array we are in
                
                //breaking point of rotated array
                if(m+1 < a.length && a[m] > a[m+1]){
                    return a[m+1];
                }
                
                if(m-1 >= 0 && a[m] < a[m-1]){
                    return a[m];
                }

                if(a[m] < a[l]){//m is in right sub array, means that min element is towards left
                    r = m - 1;
                }else{ //m is in left sub array, means that the min element would be towards right
                    l = m + 1;
                }
            }
        }
        return a[0];
    }
}