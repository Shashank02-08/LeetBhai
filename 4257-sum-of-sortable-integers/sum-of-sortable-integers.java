
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        // 1. Prefix maximum
        int[] prefMax = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        // 2. Suffix minimum
        int[] suffMin = new int[n + 1];
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        // 3. Prefix count of adjacent decreases
        int[] prefDrop = new int[n];

        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefDrop[i]++;
            }
        }

        // 4. Enumerate divisors of n
        int ans = 0;

        for (int k = 1; k <= n / k; k++) {
            if (n % k == 0) {
                if (check(nums, prefMax, suffMin, prefDrop, k)) {
                    ans += k;
                }

                int other = n / k;

                if (other != k &&
                    check(nums, prefMax, suffMin, prefDrop, other)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean check(
        int[] nums,
        int[] prefMax,
        int[] suffMin,
        int[] prefDrop,
        int k
    ) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            // Count circular decreases in this block
            int drops = prefDrop[end] - prefDrop[start];

            if (nums[end] > nums[start]) {
                drops++;
            }

            // Block must be cyclically sortable.
            // Previous blocks must also fit in sorted order.
            if (drops > 1 || prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}
