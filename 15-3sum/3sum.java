class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1])
                continue;
            else {
                for (int l = i+1, r = nums.length - 1; l < r;) {
                    int b = nums[l];
                    int c = nums[r];

                    int threeSum = a + b + c;
                    
                    if (threeSum == 0) {
                        List<Integer> tuple = list(a, b, c);
                        res.add(tuple);
                        // for finding other two sum pairs
                        l++;
                        while (l < r && nums[l] == b)
                            l++;
                    } else if (threeSum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }

    public List<Integer> list(int... nums) {
        List<Integer> l = new ArrayList<>();
        for (int i : nums) {
            l.add(i);
        }

        return l;
    }
}