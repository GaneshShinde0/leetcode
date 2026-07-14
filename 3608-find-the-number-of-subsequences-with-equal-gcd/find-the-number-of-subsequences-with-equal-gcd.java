class Solution {
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        
        // dp[i][g1][g2] represents the number of ways to form gcd1 = g1 and gcd2 = g2
        // using a subset of the first i elements.
        int[][][] dp = new int[n + 1][201][201];
        
        // Base case: Before picking any elements, there is 1 way to have two empty sequences
        dp[0][0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int g1 = 0; g1 <= 200; g1++) {
                for (int g2 = 0; g2 <= 200; g2++) {
                    // Skip states that haven't been reached yet to save time
                    if (dp[i][g1][g2] == 0) continue;
                    
                    // 1. Skip nums[i]
                    dp[i + 1][g1][g2] = (dp[i + 1][g1][g2] + dp[i][g1][g2]) % MOD;
                    
                    // 2. Add nums[i] to seq1
                    // Note: passing nums[i] as the first argument avoids modulo by zero if g1 is 0
                    int nextG1 = gcd(nums[i], g1); 
                    dp[i + 1][nextG1][g2] = (dp[i + 1][nextG1][g2] + dp[i][g1][g2]) % MOD;
                    
                    // 3. Add nums[i] to seq2
                    int nextG2 = gcd(nums[i], g2);
                    dp[i + 1][g1][nextG2] = (dp[i + 1][g1][nextG2] + dp[i][g1][g2]) % MOD;
                }
            }
        }
        
        int ans = 0;
        // Collect the final answer from dp[n]. 
        // We start from g = 1 to ensure the sequences are non-empty.
        for (int g = 1; g <= 200; g++) {
            ans = (ans + dp[n][g][g]) % MOD;
        }
        
        return ans;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
class SolutionRecursion{
    int[] nums;
    HashMap<Integer, Integer> hm;
    private int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        this.hm = new HashMap<>();
        return recurse(0, 0,0);
    }

    private int recurse(int i, int gcd1, int gcd2){
        if(i==nums.length){
            if(gcd1==0 && gcd2==0) return 0;
            return gcd1==gcd2?1:0;
        }
        int key = i+gcd1*1000+gcd2*1000000;
        if(hm.containsKey(key)) return hm.get(key);
        long longRes = 1l*recurse(i+1, gcd1, gcd2) + recurse(i+1, gcd(nums[i], gcd1), gcd2) + recurse(i+1, gcd1, gcd(nums[i], gcd2));
        int res = (int) (longRes%MOD);
        hm.put(key, res);
        return res;
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}