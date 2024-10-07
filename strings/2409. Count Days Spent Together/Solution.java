class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int i=1;i<12;i++){
            daysInMonth[i]+=daysInMonth[i-1];
        }
        int arriveAliceMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int arriveBobMonth = Integer.parseInt(arriveBob.substring(0,2));
        int arriveAliceDay = Integer.parseInt(arriveAlice.substring(3));
        int arriveBobDay = Integer.parseInt(arriveBob.substring(3));

        int leaveAliceMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int leaveBobMonth = Integer.parseInt(leaveBob.substring(0,2));
        int leaveAliceDay = Integer.parseInt(leaveAlice.substring(3));
        int leaveBobDay = Integer.parseInt(leaveBob.substring(3));

        int arriveAliceTotalDays=0,arriveBobTotalDays=0,leaveAliceTotalDays=0,leaveBobTotalDays=0;
        
        arriveAliceTotalDays=daysInMonth[arriveAliceMonth-1]+arriveAliceDay;
        arriveBobTotalDays=daysInMonth[arriveBobMonth-1]+arriveBobDay;

        leaveAliceTotalDays=daysInMonth[leaveAliceMonth-1]+leaveAliceDay;
        leaveBobTotalDays=daysInMonth[leaveBobMonth-1]+leaveBobDay;

         // Calculate the overlap in their stay
        int startTogether = Math.max(arriveAliceTotalDays, arriveBobTotalDays); // Latest arrival date
        int endTogether = Math.min(leaveAliceTotalDays, leaveBobTotalDays);     // Earliest leave date

        // If no overlap, return 0
        if (startTogether > endTogether) {
            return 0;
        }

        // Return the number of overlapping days
        return endTogether - startTogether + 1;

    }

    public int countDaysTogetherOtherOne(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int x1 = getdays(arriveAlice,monthDays);
        int y1 = getdays(leaveAlice,monthDays);
        int x2 = getdays(arriveBob,monthDays);
        int y2 = getdays(leaveBob,monthDays);
        if(x2>y1 || x1>y2)
            return 0;
        
        return Math.abs(Math.max(x1,x2)-Math.min(y1,y2))+1;
    }
    public int getdays(String time,int[] monthDays)
    {
        int total = 0;
        int months = Integer.valueOf(time.substring(0,2));
        int days = Integer.valueOf(time.substring(3,5));
        for(int i=0;i<months-1;i++)
        {
            total += monthDays[i];
        }
        total +=days;
        return total;
    }
}
