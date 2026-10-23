class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        char arr[] = new char[len];
        for ( int i = 0 ; i< len ; i++)
        {
            arr[i]= s.charAt(i);
        }
        HashSet<Character> set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        
        int left = 0;
        int right = len-1;

        while (left < right)
        {
            if (!set.contains(arr[left]))
                left++;
            else if (!set.contains(arr[right]))
                right--;
            else 
            {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);     
    }
}