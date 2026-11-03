class Solution {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int max = nums[len-1];
        
        // for (int i = 0; i< len ; i++)
        // {
        //     while (nums[i] != max)
        //     {
        //         nums[i]++;
        //         count++;
        //     }
        // }
        for (int i = 0 ; i< len ; i++)
        {
            count += (max - nums[i]);
        }
        return count;
    }
}