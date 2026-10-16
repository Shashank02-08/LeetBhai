class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length-1;
        int i =0;
        while ( i<n)
        {
            nums[i+1]=nums[i]+nums[i+1];
            i++;
        }
        return nums;
    }
}