class Solution {
    public int numPairsDivisibleBy60(int[] hours) {
        long[] hoursInDay = new long[60];
        // System.out.println(Arrays.toString(hoursInDay));
        for(int i: hours){
            hoursInDay[i%60]++;
        }
        System.out.println(Arrays.toString(hoursInDay));
        long res = hoursInDay[0]*(hoursInDay[0]-1)/2+(hoursInDay[30]*(hoursInDay[30]-1))/2;
        for(int i=1;i<30;i++){
            res += hoursInDay[i]*hoursInDay[60-i];
        }
        return (int) res;
    }
}