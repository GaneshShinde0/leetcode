class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile:piles){
            if(pile>right) right=pile;
        }
        int res = right;

        while(left<=right){
            int mid = (right-left)/2+left;
            long hours = getHours(piles,mid);
            if(hours<=h){
                res = Math.min(res,mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }
    public long getHours(int[] piles, int k){
        long hours = 0;
        for(int pile:piles){
            hours += Math.ceil((pile*1.0)/k);
        }
        return hours;
    }
}