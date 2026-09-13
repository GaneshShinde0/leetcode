class Solution {
    public int reverse(int x) {
        int sign = 1;
        
        if(x<0){
            sign = -1;
            x=-x;
        }
        long rev = 0;
        while(x>0){
            rev=rev*10+x%10;
            x/=10;
        }
        if(rev>Integer.MAX_VALUE||(rev*sign)<Integer.MIN_VALUE) return 0;
        return (int) rev*sign;
    }
}