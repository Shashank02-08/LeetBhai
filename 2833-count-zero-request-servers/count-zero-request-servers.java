// class Solution {
//     public int[] countServers(int n, int[][] logs, int x, int[] queries) {

//         int mark[] = new int[n];
//         int arr[] = new int[queries.length]; 
        
//         for (int i = 0; i< queries.length ; i++)
//         {
//             Arrays.fill(mark, 0);
            
//             int t = queries[i] - x;
//             int f = queries[i];
//             int count = 0;

//             for (int j = 0; j< logs.length ; j++)
//             {
//                 if (logs[j][1] >= t && logs[j][1] <= f)
//                 {
//                     mark[logs[j][0] - 1]++; 
//                 }
//             }
//             for ( int j = 0; j< n; j++)
//             {
//                 if (mark[j] == 0)
//                 {
//                     count++;
//                 }
//             }
//             arr[i] = count;
//         }
//         return arr;
//     }
// }
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] ans = new int[queries.length];
        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int i = 0; i < q.length; i++) {

            int start = q[i][0] - x;
            int end = q[i][0];

            // Add logs inside the right boundary
            while (right < logs.length && logs[right][1] <= end) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }

            // Remove logs outside the left boundary
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }

            ans[q[i][1]] = n - active;
        }

        return ans;
    }
}
