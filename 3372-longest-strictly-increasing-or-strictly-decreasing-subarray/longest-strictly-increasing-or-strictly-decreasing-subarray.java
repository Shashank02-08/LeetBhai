// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int len = nums.length;
//         int ans;
//         int incCount=0;
//         int decCount=0;
//         int ogSub = 0;
//         for(int i = 0 ; i< len=1 ; i++)
//         {
//             ogSub = 
//             ans = 
//             for (int j = i ; j < len-1 ; j++)
//             {
                
//                 if ( nums[j]> nums[j+1])
//                 {
//                     decCount++;
//                 }
//                 else if 
//                 {
//                     incCount++;
//                 }
//             }
//             Math.max()
//         }
//     }
// }
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int inc = 1, dec = 1, ans = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) {
                dec++;
                inc = 1;
            } else if(nums[i] > nums[i-1]) {
                inc++;
                dec = 1;
            } else {
                inc = dec = 1;
            }

            ans = Math.max(ans, Math.max(inc, dec));
        }

        return ans;
    }
}