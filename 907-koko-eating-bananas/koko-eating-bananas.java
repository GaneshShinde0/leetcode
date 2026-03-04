class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0, left = 1; // left is 1 banana per hour
        for(int p:piles){
            right = Math.max(p,right); // Right is maximum pile per hour.
        }
        while(left<right){
            int mid = (left)+(right-left)/2;
            int hours = getHours(mid, piles); // Hours taken to finish pile for any mid amount of bananas.
            if(hours<=h) right = mid; // If hours spent by koko are less than hours given; we can eat mid amount of bananas with ease.
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