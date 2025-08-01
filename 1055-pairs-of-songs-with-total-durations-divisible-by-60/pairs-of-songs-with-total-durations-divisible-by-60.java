class Solution {
    public int numPairsDivisibleBy60(int[] hours) {
        long[] hoursInDay = new long[60];
        for(int i: hours){
            hoursInDay[i%60]++;
        }
        // System.out.println(Arrays.toString(hoursInDay));
        long res = hoursInDay[0]*(hoursInDay[0]-1)/2;
        res += hoursInDay[30]*(hoursInDay[30]-1)/2;
        // System.out.println(res);

        for(int i=1;i<30; i++){
            // System.out.println(i + ": "+hoursInDay[i]+"-"+hoursInDay[24-i]);
            res+= (hoursInDay[i]*hoursInDay[60-i]);
        }
        return (int) res;
    }
}