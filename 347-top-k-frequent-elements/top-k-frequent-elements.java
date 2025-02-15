class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Step 2: Create buckets where index represents frequency
        List<Integer>[] buckets = new ArrayList[maxFrequency + 1];

        // Step 3: Put numbers in their frequency buckets
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
            buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(number);
        }

        // Step 4: Collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int freq = maxFrequency; freq >= 0 && index < k; freq--) {
            if (buckets[freq] != null) {
            for (int num : buckets[freq]) {
                if (index < k) {
                result[index++] = num;
                } else {
                break;
                }
            }
            }
        }

        return result;
    }
}