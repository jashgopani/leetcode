class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int t = m+n-1;

        while (i>=0 && j>=0){
            if (nums1[i] >= nums2[j]){
                nums1[t]=nums1[i];
                t--;
                i--;
            }else{
                nums1[t]=nums2[j];
                t--;
                j--;
            }
        }
        while (j >= 0){
            nums1[t] = nums2[j];
            t--;
            j--;
        }
    }
}