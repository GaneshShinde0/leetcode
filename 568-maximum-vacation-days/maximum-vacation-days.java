public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (days.length == 0 || flights.length == 0) return 0;
        int[] dp = new int[days.length];
        for (int week = days[0].length - 1; week >= 0; week--) {
            int[] temp = new int[days.length];
            for (int cur_city = 0; cur_city < days.length; cur_city++) {
                temp[cur_city] = days[cur_city][week] + dp[cur_city];
                for (int dest_city = 0; dest_city < days.length; dest_city++) {
                    if (flights[cur_city][dest_city] == 1) {
                        temp[cur_city] = Math.max(days[dest_city][week] + dp[dest_city], temp[cur_city]);
                    }
                }
            }
            dp = temp;
        }

        return dp[0];
    }
}