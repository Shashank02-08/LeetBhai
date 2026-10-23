class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashSet<Integer> ans = new HashSet<>();
        for ( int i = 0 ; i< len1 ; i++)
        {
            for (int j = 0 ; j<len2; j++)
            {
                if (nums1[i] == nums2[j])
                {
                    ans.add(nums1[i]);
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}