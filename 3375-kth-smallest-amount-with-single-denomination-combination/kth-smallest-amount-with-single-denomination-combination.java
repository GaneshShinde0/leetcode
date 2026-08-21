class Solution {
    private int[] coins;
    public long findKthSmallest(int[] coins, int k) {
        this.coins = coins;
        Arrays.sort(coins);
        long left = coins[0], right = 1l*k*coins[0];
        while(left<right){
            long mid = (left+right)/2;
            long coinsFound = count(mid);
            if(coinsFound>=k){ // 
                right = mid;
            }else if(coinsFound<k){
                left = mid+1;
            }
        }
        return left;
    }
    private long count(long x){
        long total = 0;
        // Enumerate every non-empty subset of coins using bitmask.
        // mask's bits tell us which coins belong to this subset.
        for(int mask = 1; mask < (1 << coins.length); mask++){
            long lcm = 1;
            for(int i = 0; i < coins.length; i++){
                if(((1<<i) & mask) > 0) {
                    lcm = lcm(coins[i], lcm); // lcm of all coins included in this subset
                    if(lcm > x) break;  // stop building THIS subset's lcm early
                }
            }

            // x / lcm = count of numbers <= x divisible by EVERY coin in this subset
            // (i.e., the size of the intersection of "multiples of coin_i" sets for i in subset)

            if(Integer.bitCount(mask) % 2 == 0){
                // Even-sized subset -> this intersection was already
                // double-counted when we added its individual smaller subsets,
                // so we cancel out the over-count by subtracting it.
                total -= x/lcm;
            } else {
                // Odd-sized subset -> by the inclusion-exclusion pattern
                // (+ for size 1, - for size 2, + for size 3, ...),
                // this intersection needs to be added back in.
                total += x/lcm;
            }
        }
        return total; // total number of amounts <= x achievable by at least one coin
    }
    private long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
    private long gcd(long a, long b){
        return a%b==0?b:gcd(b,a%b);
    }
}