class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();

        HashSet<Character> vowel = new HashSet<>();

        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');

        int mid = len/2;

        String a = s.substring(0, mid);
        String b = s.substring(mid, len);

        int count1 = 0;
        int count2 = 0;

        for ( int i = 0 ; i< a.length(); i++)
        {
            if (vowel.contains(a.charAt(i)))
            {
                count1++;
            }
        } 

        for ( int j = 0 ; j < b.length(); j++)
        {
            if (vowel.contains(b.charAt(j)))
            {
                count2++;
            }
        } 

        if (count1 == count2)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}