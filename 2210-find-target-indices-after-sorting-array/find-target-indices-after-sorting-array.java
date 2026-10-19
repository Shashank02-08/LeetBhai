class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> x = new ArrayList<>();
        for ( int i = 0 ; i< len ; i++)
        {
            if (nums[i]== target)
            {
                x.add(i);
            }
        }
        return x;
    }
}