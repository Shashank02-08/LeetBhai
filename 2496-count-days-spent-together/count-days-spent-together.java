class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] months = {31, 28, 31, 30, 31, 30,
                        31, 31, 30, 31, 30, 31};

        int aStart = getDays(arriveAlice, months);
        int aEnd = getDays(leaveAlice, months);
        int bStart = getDays(arriveBob, months);
        int bEnd = getDays(leaveBob, months);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);

        return Math.max(0, end - start + 1);
    }

    private int getDays(String date, int[] months) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += months[i];
        }

        return total;
    }
}