class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        String x = s.toLowerCase();
        int left = 0;
        int right = n-1;
        while(left < right)
        {
            char l = x.charAt(left);
            char r = x.charAt(right);
            if (!(l>= 'a' && l <= 'z' || l>= '0' && l<= '9'))
            { 
                left++;
            }
            else if (!(r>= 'a' && r <= 'z' || r>= '0' && r<= '9'))
            {
                right--;
            }
            else
            {
                if ( l != r)
                {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}