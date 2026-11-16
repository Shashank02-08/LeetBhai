// class Solution {
//     public String digitSum(String s, int k) {
//         int len = s.length();
//         StringBuilder ans = new StringBuilder();

//         int size;
//         if (len % k == 0)
//         {
//             size = len/k;
//         }
//         else 
//         {
//             size = (len/k) +1;
//         }

//         int arr[] = new int[size];

//         for (int i = 0 ; i< len ; i++)
//         {
            
//         }   
//     }
// }
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < s.length() && j < i + k; j++) {
                    sum += s.charAt(j) - '0';
                }
                next.append(sum);
            }
            s = next.toString();
        }
        return s;
    }
}