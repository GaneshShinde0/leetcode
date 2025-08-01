class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long[] hoursInDay = new long[24];
        for(int i: hours){
            hoursInDay[i%24]++;
        }
        System.out.println(Arrays.toString(hoursInDay));
        long res = hoursInDay[0]*(hoursInDay[0]-1)/2;
        res += hoursInDay[12]*(hoursInDay[12]-1)/2;
        // System.out.println(res);

        for(int i=1;i<12; i++){
            // System.out.println(i + ": "+hoursInDay[i]+"-"+hoursInDay[24-i]);
            res+=(long) (hoursInDay[i]*hoursInDay[24-i]);
        }
        return res;
    }
}