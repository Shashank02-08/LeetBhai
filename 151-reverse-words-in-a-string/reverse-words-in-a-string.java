class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ");
        s = s.trim();
        int len = s.length();
        char x[] = new char[len];
        for (int i = 0; i< len ; i++)
        {
            x[i]=s.charAt(i);
        }
        int left = 0;
        int right = len -1;
        while (left < right)
        {
            char temp = x[left];
            x[left] = x[right];
            x[right] = temp;
            left++; 
            right--;
        }

        int l = 0;
        int r = 0;
        while(r < len)
        {
            if ( x[r] == ' ' || r == len-1)
            {
                int u = l;
                int i;
                if ( r == len -1)
                {
                    i = r;
                }
                else
                {
                    i = r-1;
                }
                while ( u < i)
                {
                    char temp = x[u];
                    x[u]=x[i];
                    x[i] = temp;
                    u++;
                    i--;
                }
                l = r+1;
            }
            r++;
        }
        StringBuilder ans = new StringBuilder();

        for ( int i =  0; i< len;i++)
        {
            ans.append(x[i]);
        }
        return ans.toString();
    }
}