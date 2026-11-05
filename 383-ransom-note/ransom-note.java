// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         char[] arr = magazine.toCharArray();
//         int len = arr.length;
//         int len1 = ransomNote.length();

//         for(int i = 0; i< len1 ; i++ )
//         {
//             boolean mark = false;
//             for (int j =0; j< len ; j++)
//             {
//                 if (ransomNote.charAt(i) == arr[j])
//                 {
//                     arr[j] = '0';
//                     mark = true;
//                     break;
//                 }
//             }
//             if (!mark)
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';

            if (freq[index] == 0) {
                return false;
            }

            freq[index]--;
        }

        return true;
    }
}