class Solution {
    public int maxDistToClosestNaive(int[] seats) {
        int longest0=0;
        int len = seats.length;
        int left=0,right=0,mid=1;
        int prevMid=1;
        boolean leftCheck=true,midCheck=false,rightCheck=true;
        for(int i=0;i<seats.length;i++){
            if(leftCheck && seats[i]==0){
                left++;
            }else if (seats[i]==1) leftCheck=false;

            if(rightCheck && seats[len-i-1]==0){
                right++;
            }else if (seats[len-i-1]==1) rightCheck=false;

            if (!leftCheck && seats[i]==0){
                prevMid+=1;
            }else if (!leftCheck && seats[i]==1) prevMid=0;
            mid = Math.max(mid, prevMid);
        }
        return Math.max(Math.max(left,right),(mid+1)/2);
    }

    public int maxDistToClosest(int[] seats) {
        int countOfFreeSeats = 0;
        int maxCountOfFreeSeats = 0;
        int countOfStartSeats = 0;
        int i = 0;
        while (seats[i] != 1) {
            countOfStartSeats++;
            i++;
        }
        for (; i < seats.length; ++i) {
            if (seats[i] == 0) {
                countOfFreeSeats++;
            } else {
                if (countOfFreeSeats > maxCountOfFreeSeats) {
                    maxCountOfFreeSeats = countOfFreeSeats;
                }
                countOfFreeSeats = 0;
            }
        }

        return Math.max(countOfStartSeats, Math.max(countOfFreeSeats, maxCountOfFreeSeats / 2 + maxCountOfFreeSeats % 2));
    }
}
