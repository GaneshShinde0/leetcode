class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for(int t:time) maxTime = Math.max(maxTime,t);
        long left = 1, right = 1l*maxTime*totalTrips;

        while(left<right){
            long mid = (left+right)/2;
            if(isTimeEnough(time, mid, totalTrips)){
                right = mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public boolean isTimeEnough(int[] time, long currentTime, int totalTrips){
        long actualTrips = 0;
        for(int t:time){
            actualTrips += currentTime/t;
        }
        return actualTrips>=totalTrips;
    }
}