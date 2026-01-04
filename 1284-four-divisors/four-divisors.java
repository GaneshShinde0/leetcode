class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int n:nums){
            int localSum = 1+n, divisors = 0;
            int i=2;
            for(;i*i<n;i++){
                if(n%i==0){
                    localSum+=(n/i+i);
                    divisors+=2;
                }
                if(divisors>2){
                    localSum=0;
                    break;
                }
            }
            if(i*i==n) continue;
            if(divisors==2) res+=localSum;
        }
        return res;
    }
}