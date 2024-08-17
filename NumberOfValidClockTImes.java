class Solution {
    public int countTime(String time) {
        char[] times = time.toCharArray();
        int res =1;
        if (times[0]=='?' && (times[1]>'3'&&times[1]<='9')) res*=2;
        if (times[0]=='?' && (times[1]<='3'&&times[1]>='0')) res*=3;
        if (times[1]=='?' && times[0]=='0') res*=10;
        if (times[1]=='?' && times[0]=='1') res*=10;
        if (times[1]=='?' && times[0]=='2') res*=4;
        if (times[1]=='?' && times[0]=='?') res*=24;
        if (times[3]=='?') res*=6;
        if (times[4]=='?') res*=10;

        return res;
    }

    public int countTimeRefactored(String time) {
        int hoursPossibilities = 1;
        int minutesPossibilities = 1;

        // Handle hours
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            hoursPossibilities = 24; // Both '?' can represent any hour
        } else if (time.charAt(0) == '?') {
            hoursPossibilities = (time.charAt(1) >= '0' && time.charAt(1) <= '3') ? 3 : 2;
        } else if (time.charAt(1) == '?') {
            hoursPossibilities = (time.charAt(0) == '2') ? 4 : 10;
        }

        // Handle minutes
        if (time.charAt(3) == '?') {
            minutesPossibilities *= 6; // First digit can be 0-5
        }
        if (time.charAt(4) == '?') {
            minutesPossibilities *= 10; // Second digit can be 0-9
        }

        return hoursPossibilities * minutesPossibilities;
    }
}
