class Solution {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;

        // int count = 0;

        // for (int j = 0; j< len ; j++)
        // {
        //     if (nums[j]> max)
        //     {
        //         max = nums[j];
        //     }
        // }

        // for (int i = 0 ; i< len ; i++)
        // {
        //     count += (max - nums[i]);
        // }
        // return count;
        
        // for (int i = 0; i< len ; i++)
        // {
        //     while (nums[i] != max)
        //     {
        //         nums[i]++;
        //         count++;
        //     }
        // }
        
        int sum = 0;

        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }

        return nums.length * max - sum;
    }
}