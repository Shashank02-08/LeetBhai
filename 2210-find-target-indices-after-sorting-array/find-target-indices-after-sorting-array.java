class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int len = nums.length;
        int smaller = 0;
        int equal=0 ;
        ArrayList<Integer> x = new ArrayList<>();
        for ( int i = 0 ; i< len ; i++)
        {
            if (nums[i] < target)
            {
                smaller++;
            }
            if ( nums[i] == target)
            {
                equal++;
            }
        }
        for ( int i = smaller; i < smaller + equal ; i++)
        {
            x.add(i);
        }
        return x;
    }
}