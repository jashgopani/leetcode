class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int arr[] = nums.clone();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            int a = arr[i];

            if(i>0 && a==arr[i-1])continue;

            for(int l=i+1, r=arr.length-1;l<r;){
                int b = arr[l];
                int c = arr[r];

                int threeSum = a+b+c;

                if(threeSum==0){
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(a);
                    tuple.add(b);
                    tuple.add(c);
                    res.add(tuple);
                    while(l<r && arr[l]==b) l++;
                }else if(threeSum < 0){
                    while(l<r && arr[l]==b) l++;
                }else{
                    r--;
                    while(l<r && arr[r]==c) r--;
                }
            }
        }

        return res;
    }
}