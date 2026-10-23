class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> ans = new HashSet<>();

        for ( int i = 0; i< nums.length; i++)
        {
            if ( i> k)
            {
                ans.remove(nums[i-k-1]);
            }
            if (ans.contains(nums[i]))
            {
                return true;
            }
            ans.add(nums[i]);
        }
        return false;
    }
}