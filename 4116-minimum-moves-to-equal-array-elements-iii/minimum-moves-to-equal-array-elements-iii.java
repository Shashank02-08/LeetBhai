class Solution {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int j = 0; j< len ; j++)
        {
            if (nums[j]> max)
            {
                max = nums[j];
            }
        }
        
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