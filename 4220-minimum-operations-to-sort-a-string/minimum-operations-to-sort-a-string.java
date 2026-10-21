
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char min = s.charAt(0);
        char max = s.charAt(0);
        boolean sorted = true;
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);

            if (i > 0 && s.charAt(i - 1) > c) {
                sorted = false;
            }
        }

        if (sorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == min) minCount++;
            if (s.charAt(i) == max) maxCount++;
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min
                && minCount == 1 && maxCount == 1) {
            return 3;
        }

        return 2;
    }
}
