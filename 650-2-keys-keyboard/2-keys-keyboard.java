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
    public int minSteps(int n) {
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