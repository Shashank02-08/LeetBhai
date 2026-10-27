class Solution {
    public String countAndSay(int n) {
        // StringBuilder ans = new StringBuilder<>();
        // ans.append("1");
        String s ="1";
        for ( int i = 1 ; i < n ; i++)
        {
            StringBuilder ans = new StringBuilder();
            int j = 0;

            while ( j < s.length())
            {
                int count = 1;
                while ( j+1 < s.length() && s.charAt(j) == s.charAt(j+1))
                {
                    count++;
                    j++;
                }

                ans.append(count);
                ans.append(s.charAt(j));
                j++;
            }
            s= ans.toString();
        }
        return s;
    }
}