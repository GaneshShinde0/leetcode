class Solution {
    public int minDays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=-1;
        for(int i=0;i<=n;i++){
            if(dp[i]==Integer.MAX_VALUE) continue;
            for(int k=1;k<=n;k++){
                int points = k*(k+1)/2;
                if(i+points<=n){
                    dp[i+points] = Math.min(dp[i+points], dp[i]+k+1);
                }else{
                    break;
                }
            }
        }
        return dp[n];
    }
}