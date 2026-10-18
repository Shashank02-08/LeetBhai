class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        String x = s.toLowerCase();
        StringBuilder a = new StringBuilder();
        for ( int i =0 ; i< n ; i++)
        {
            char c = x.charAt(i);
            if (c>= 'a' && c <= 'z' || c>= '0' && c<= '9')
            {
                a.append(c);
            }
        }
        int y = a.length();
        int left = 0;
        int right = y-1;
        while(left < right)
        {
            if ( a.charAt(left) != a.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}