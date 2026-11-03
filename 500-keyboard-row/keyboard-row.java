class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();

        set1.add('q');
        set1.add('w');
        set1.add('e');
        set1.add('r');
        set1.add('t');
        set1.add('y');
        set1.add('u');
        set1.add('i');
        set1.add('o');
        set1.add('p');

        set2.add('a');
        set2.add('s');
        set2.add('d');
        set2.add('f');
        set2.add('g');
        set2.add('h');
        set2.add('j');
        set2.add('k');
        set2.add('l');

        set3.add('z');
        set3.add('x');
        set3.add('c');
        set3.add('v');
        set3.add('b');
        set3.add('n');
        set3.add('m');

        int len = words.length;
        ArrayList<String> ans = new ArrayList<>();

        for(int i =0; i< len ; i++)
        {
            String s =words[i].toLowerCase();
            HashSet<Character> checkSet;
            int j =1;
            if (set1.contains(s.charAt(0)))
            {
                checkSet= set1;
            }
            else if (set2.contains(s.charAt(0)))
            {
                checkSet= set2;
            }
            else 
            {
                checkSet= set3;
            }
            boolean mark = true;
            while(  j < s.length())
            {
                if (!checkSet.contains(s.charAt(j)))
                {
                    mark = false;
                    break;
                }
                j++;
            }

            if(mark)
            {
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[0]);
    }
}