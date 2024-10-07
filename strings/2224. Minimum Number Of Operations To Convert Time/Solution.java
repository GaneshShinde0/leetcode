class Solution {
    public int convertTime(String current, String correct) {
        int minHour = Math.abs(Integer.valueOf(current.substring(0,2))-Integer.valueOf(correct.substring(0,2)));
        // minHour = Math.min(minHour,24-minHour);
        int minMinutes = minHour*60-Integer.valueOf(current.substring(3))+Integer.valueOf(correct.substring(3));
        // minMinutes = Math.min(minMinutes,60-minMinutes);
        // System.out.println(minMinutes);
        int res=0;
        if(minMinutes>=60) {
            res+=minMinutes/60;
            minMinutes = minMinutes%60;
        }
        if(minMinutes>=15) {
            res+=minMinutes/15;
            minMinutes = minMinutes%15;
        }
        if(minMinutes>=5) {
            res+=minMinutes/5;
            minMinutes = minMinutes%5;
        }
        res += minMinutes;
        return res;
    }
}
