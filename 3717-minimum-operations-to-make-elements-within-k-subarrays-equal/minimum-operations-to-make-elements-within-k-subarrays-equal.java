// // // class Solution {
// // //     public long minOperations(int[] nums, int x, int k) {
// // //         int len = nums.length;
// // //         int ogCount = Integer.MAX_VALUE;

// // //         for ( int i = 0; i<= len-x ; i++)
// // //         {
// // //             int[] arr = Arrays.copyOfRange(nums, i, i + x);
// // //             Arrays.sort(arr);
// // //             int median = arr.length/2;
// // //             int count = 0;

// // //             for (int j = 0; j< arr.length; j++)
// // //             {
// // //                 if (j == median)
// // //                 {
// // //                     continue;
// // //                 }
// // //                count += Math.abs(arr[j] - arr[median]);
// // //             }
// // //             if (count < ogCount)
// // //             {
// // //                 ogCount = count;
// // //             }
// // //         }
// // //         return ogCount;
// // //     }
// // // }


// class Solution {
//     public long minOperations(int[] nums, int x, int k) {

//         int n = nums.length;

//         // Step 1: Calculate cost of every subarray
//         long[] cost = new long[n - x + 1];

//         for (int i = 0; i <= n - x; i++) {

//             int[] arr = Arrays.copyOfRange(nums, i, i + x);

//             Arrays.sort(arr);

//             int median = arr[x / 2];
//             long count = 0;

//             for (int j = 0; j < x; j++) {
//                 count += Math.abs((long) arr[j] - median);
//             }

//             cost[i] = count;
//         }

//         // Step 2: Create DP table
//         long INF = Long.MAX_VALUE / 2;

//         long[][] dp = new long[n + 1][k + 1];

//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], INF);
//             dp[i][0] = 0;
//         }

//         // Step 3: DP
//         for (int i = 1; i <= n; i++) {

//             for (int j = 1; j <= k; j++) {

//                 // Skip current element
//                 dp[i][j] = dp[i - 1][j];

//                 // Select subarray of length x
//                 if (i >= x && dp[i - x][j - 1] != INF) {

//                     dp[i][j] = Math.min(
//                         dp[i][j],
//                         dp[i - x][j - 1] + cost[i - x]
//                     );
//                 }
//             }
//         }

//         return dp[n][k] == INF ? -1 : dp[n][k];
//     }
// }

class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        long lowSum = 0;
        long highSum = 0;

        int lowSize = 0;
        int highSize = 0;

        int size = 0;

        void addToMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeFromMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void addLow(int val) {
            addToMap(low, val);
            lowSum += val;
            lowSize++;
        }

        void addHigh(int val) {
            addToMap(high, val);
            highSum += val;
            highSize++;
        }

        int removeLow() {
            int val = low.lastKey();
            removeFromMap(low, val);
            lowSum -= val;
            lowSize--;
            return val;
        }

        int removeHigh() {
            int val = high.firstKey();
            removeFromMap(high, val);
            highSum -= val;
            highSize--;
            return val;
        }

        void rebalance() {
            int target = (size + 1) / 2;

            while (lowSize > target) {
                addHigh(removeLow());
            }

            while (lowSize < target) {
                addLow(removeHigh());
            }
        }

        void add(int val) {
            if (lowSize == 0 || val <= low.lastKey()) {
                addLow(val);
            } else {
                addHigh(val);
            }

            size++;
            rebalance();
        }

        void remove(int val) {
            if (low.containsKey(val)) {
                removeFromMap(low, val);
                lowSum -= val;
                lowSize--;
            } else {
                removeFromMap(high, val);
                highSum -= val;
                highSize--;
            }

            size--;
            rebalance();
        }

        long getCost() {
            long median = low.lastKey();

            return median * lowSize - lowSum
                    + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        if ((long) x * k > n) {
            return -1;
        }

        // Step 1: Calculate cost of every window

        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = 1; i <= n - x; i++) {

            window.remove(nums[i - 1]);
            window.add(nums[i + x - 1]);

            cost[i] = window.getCost();
        }

        // Step 2: Initialize DP

        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        // Step 3: DP transitions

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Choice 1: Skip current element

                dp[i][j] = dp[i - 1][j];

                // Choice 2: Select a subarray of length x

                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
