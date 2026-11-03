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
        int count = 0;

        for ( int i = 0 ; i< len; i++)
        {
            if (vowel.contains(s.charAt(i)))
            {
                if (i < mid)
                {
                    count++;
                }
                else
                {
                    count--;
                }
            }
        } 

        return count == 0;
    }
}