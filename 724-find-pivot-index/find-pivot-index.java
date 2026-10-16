class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int [] prefix = new int[n];
        prefix[0]=nums[0];
        int i = 1;
        while (i< n)
        {
            prefix[i]=nums[i] + prefix[i-1];
            i++;
        }

        int[] surfix = new int[n];
        surfix[n-1]=nums[n-1];
        int j = n-2;
        while (j>=0)
        {
            surfix[j]=nums[j] + surfix[j+1];
            j--;
        }

        int x = 0;
        while (x<n)
        {
            if (prefix[x]==surfix[x])
            {
                return x;
            }
            x++;
        }
        return -1;
    }
}