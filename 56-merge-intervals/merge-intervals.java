class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort the intervals by the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= prev[1]) {
                // Overlapping intervals, merge them
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                // Non-overlapping interval, add the previous interval and update prev
                res.add(prev);
                prev = curr;
            }
        }
        // Add the last interval
        res.add(prev);

        // Convert the list to a 2D array and return
        return res.toArray(new int[res.size()][]);
    }
}