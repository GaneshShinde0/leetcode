/*
1=>0
2=>2
3=>3
4=>4
5=>5
6=>3+2=>5
7=>
*/

class Solution {
    // This problem is same as sum of all prime factors.
    public int minSteps(int n){
        int ans = 0;
        int d = 2;
        while(n>1){
            // If d is the prime factor of n, keep dividing n by d until no longer divisible.
            while(n%d==0){
                ans+=d;
                n/=d;
            }
            d++;
        }
        return ans;
    }
    public int minStepsInitial(int n) {
        if(n==1) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0;i<=n;i++){
            if(i<6){
                dp[i]=i;
            }else{
                dp[i]=i;
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i%j==0){
                        dp[i]=Math.min(dp[i],dp[j]+i/j);
                        dp[i]=Math.min(dp[i],dp[i/j]+j);
                    }
                }
            }
        }
        return dp[n];
    }
}