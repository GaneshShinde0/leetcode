class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            long gcd = nums[i], lcm = nums[i], prod = nums[i];
            for(int j = i+1; j<n;j++){
                prod = prod* (long)nums[j];
                gcd = gcd(gcd, ( long)nums[j]);
                lcm = lcm(lcm, ( long)nums[j]);
                if(prod == gcd * lcm){ ans = Math.max(ans, j - i + 1); }
            }
        }
        return ans;
    }

    long gcd(long a, long b){
        return b==0?a:gcd(b,a%b);
    }

    long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
}