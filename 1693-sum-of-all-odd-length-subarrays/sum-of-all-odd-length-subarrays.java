class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for ( int i =0;i< n;i++)
        {
            int subsum = 0;
            for ( int j =i ; j <n ; j++)
            {
                subsum += arr[j];
                if ( (j-i) % 2 == 0)
                {
                    sum += subsum;
                }
            }
        }
        return sum;
    }
}