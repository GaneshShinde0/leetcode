/*
# Intuition:
- Calculating a^b%1337 directly isn't feasible when b is a huge arrray. We can't build the full number, but we can apply math of modular exponentiation and reduce step-by-step.

Approach 

- (a^b)%c = ((a%c)^b)%c
- process each digit d of b from left to right.
- At each step: raise current result to the 10th power and multiply by a^d, all modulo 1337.

Time Complexity: O(n) => n= len(b)
Space: O(1);
*/

class Solution {
    private static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        a%=MOD;
        int[] pow = new int[10];
        pow[0] = 1;
        for(int i=1;i<10;i++){
            pow[i] = (pow[i-1]*a)%MOD;
        }
        long ans = pow[b[0]];
        for(int i=1;i<b.length;i++){
            ans = (power(ans,10)*pow[b[i]])%MOD;
        }
        return (int) ans;
    }
    private long power(long a, int p){
        long res = 1;
        while(p-->0) res = (res*a)%MOD;
        return res;
    }
}