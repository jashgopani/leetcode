class Solution {
    public int search(int[] a, int target) {
        int l=0, r=a.length-1;
        while(l<=r){
            int m = l + (r-l)/2;

            if(a[m] == target) return m;
            if(a[l] == target) return l;
            if(a[r] == target) return r;

            if(a[l] < a[r]){
                if(a[m] > target) r = m - 1;
                else l = m + 1;
            }else if(a[m] > a[l]){
                //left sub array
                if(target > a[l] && target < a[m]){
                    r = m - 1; //find in current region only
                }else{
                    l = m + 1; //move to other region
                }
            }else{
                //right sub array
                if (target < a[r] && target > a[m]){
                    l = m + 1; //find in current region
                }else{
                    r = m - 1; //move to other region
                }
            }
        }
        return -1;  
    }
}