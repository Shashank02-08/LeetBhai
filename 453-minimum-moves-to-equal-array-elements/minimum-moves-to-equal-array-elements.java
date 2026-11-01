// // // class Solution {
// // //     public int minMoves(int[] nums) {
// // //         int len = nums.length;

// // //         int max = Integer.MIN_VALUE;
// // //         for (int i = 0; i< len ; i++)
// // //         {
// // //             if(nums[i]>max)
// // //             {
// // //                 max=nums[i];
// // //             }
// // //         }
// // //         int count =0;
// // //         while (max == nums[0])
// // //         {
// // //             for ( int j = 0; j < len ; j++)
// // //             {
// // //                 for( int k = 0; k<len;k++)
// // //                 {
// // //                     if(nums[k] > max)
// // //                     {
// // //                         max = nums[k];
// // //                     }
// // //                 }
// // //                 if( nums[j] == max)
// // //                 {
// // //                     continue;
// // //                 }
// // //                 nums[j]+=1;
// // //             }
// // //             count++;
// // //         }   
// // //         return count;
// // //     }
// // // }

// // class Solution {
// //     public int minMoves(int[] nums) {
// //         int len = nums.length;

// //         int max = Integer.MIN_VALUE;

// //         for (int i = 0; i < len; i++) {
// //             if (nums[i] > max) {
// //                 max = nums[i];
// //             }
// //         }

// //         int count = 0;

// //         while (true) {
// //             boolean equal = true;

// //             for (int i = 0; i < len; i++) {
// //                 if (nums[i] != max) {
// //                     equal = false;
// //                     break;
// //                 }
// //             }

// //             if (equal) {
// //                 break;
// //             }

// //             for (int j = 0; j < len; j++) {
// //                 if (nums[j] != max) {
// //                     nums[j]++;
// //                 }
// //             }

// //             count++;

// //             max = Integer.MIN_VALUE;

// //             for (int i = 0; i < len; i++) {
// //                 if (nums[i] > max) {
// //                     max = nums[i];
// //                 }
// //             }
// //         }

// //         return count;
// //     }
// // }
// class Solution {
//     public int minMoves(int[] nums) {
//         int len = nums.length;
//         int count = 0;

//         while (true) {
//             int min = Integer.MAX_VALUE;

//             // Find the minimum element
//             for (int i = 0; i < len; i++) {
//                 min = Math.min(min, nums[i]);
//             }

//             // Check if all elements are equal
//             boolean equal = true;

//             for (int i = 0; i < len; i++) {
//                 if (nums[i] != min) {
//                     equal = false;
//                     break;
//                 }
//             }

//             if (equal) {
//                 break;
//             }

//             // Increment all elements except one minimum
//             boolean skipped = false;

//             for (int i = 0; i < len; i++) {
//                 if (!skipped && nums[i] == min) {
//                     skipped = true;
//                 } else {
//                     nums[i]++;
//                 }
//             }

//             count++;
//         }

//         return count;
//     }
// }
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - min;
        }

        return count;
    }
}