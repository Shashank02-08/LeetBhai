class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int median = nums[len / 2];

        int count = 0;

        for (int i = 0; i < len; i++) {
            count += Math.abs(nums[i] - median);
        }

        return count;
    }
}