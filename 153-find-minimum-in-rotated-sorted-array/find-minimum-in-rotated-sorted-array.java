class Solution {
    public int findMin(int[] a) {
        int l=0, r=a.length-1;
        while(l <= r){
            int m = l + (r-l)/2;

            if(a[r] > a[l]){
                //normal binary search
                return a[l];
            }else{
                //detect which sub array we are in
                if(m+1 < a.length && a[m] > a[m+1]){
                    return a[m+1];
                }
                
                if(m-1 >= 0 && a[m] < a[m-1]){
                    return a[m];
                }

                //we are in right sub array
                if(a[m] < a[l]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }
        return a[0];
    }
}