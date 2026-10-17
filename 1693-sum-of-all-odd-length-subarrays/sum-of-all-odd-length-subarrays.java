class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for ( int i =0;i< n;i++)
        {
            for ( int j =n-1 ; j >=i ; j--)
            {
                if ( (j-i) % 2 == 0)
                {
                    int x = j;
                    while (x >= i)
                    {
                        sum += arr[x];
                        x--;
                    }
                }
            }
        }
        return sum;
    }
}