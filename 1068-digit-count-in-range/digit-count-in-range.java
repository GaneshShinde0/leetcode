/*
1. When d>0,the remainder should be larget than i*d instead of i;
2. When d == 0 , when analyzing the remainder, we need to avoid taking numbers iwth heading like 0xxxx into the total count.
*/
class Solution {
    public int digitsCount(int d, int low, int high) {
        return countDigit(high,d)-countDigit(low-1,d);
    }
    int countDigit(int n, int d){
        if(n<0||n<d) return 0;
        int count = 0;
        for(int i=1;i<=n;i*=10){
            int divider = i*10;
            count+=(n/divider)*i;
            if(d>0){
                count += Math.min(Math.max(n%divider-d*i+1,0),i);
            }else{
                if(n/divider>0){
                    if(i>1){
                        count-=i;
                        count+=Math.min(n%divider+1,i);
                    }
                }
            }
        }
        return count;
    }
}