class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0, left = 1;
        for(int p:piles){
            right = Math.max(p,right);
        }
        while(left<right){
            int mid = (left)+(right-left)/2;
            int hours = getHours(mid, piles); // Hours taken to finish pile for any mid.
            if(hours<=h) right = mid;
            else left = mid+1;
        }
        return right;
    }

    private int getHours(int speed, int[] piles){
        int res = 0;
        for(int i:piles){
            res+=(int)(Math.ceil(1.0*i/speed));
        }
        return res;
    }
}