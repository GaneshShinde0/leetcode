class Solution {
    private int[] coins;
    public long findKthSmallest(int[] coins, int k) {
        this.coins = coins;
        Arrays.sort(coins);
        long left = coins[0], right = 1l*k*coins[0];
        while(left<right){
            long mid = (left+right)/2;
            long coinsFound = count(mid);
            if(coinsFound>=k){
                right = mid;
            }else if(coinsFound<k){
                left = mid+1;
            }
        }
        return left;
    }

    private long count(long x){
        long total = 0;
        for(int mask = 1; mask<(1<<coins.length); mask++){
            long lcm = 1;
            for(int i = 0; i<coins.length; i++){
                if(((1<<i)&mask)>0) lcm = lcm(coins[i],lcm);
            }
            if(Integer.bitCount(mask)%2==0){
                total -=x/lcm;
            }else{
                total+=x/lcm;
            }
        }
        return total;
    }
    private long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
    private long gcd(long a, long b){
        return a%b==0?b:gcd(b,a%b);
    }
}