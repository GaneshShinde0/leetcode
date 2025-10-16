class Solution {
    private static final int[] DAYS_IN_MONTH = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int numberOfDays(int year, int month) {
        return month != 2 ? DAYS_IN_MONTH[month] : year % 100 == 0 ? year % 400 == 0 ? 29 : 28 : year % 4 == 0 ? 29 : 28;
    }
}