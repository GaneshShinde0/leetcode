class Solution {
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        int n = price.length;
        int[][][] dp = new int[n+1][maxAmount+1][maxCoupons+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=maxAmount;j++){
                for(int k=0;k<=maxCoupons;k++){
                    dp[i+1][j][k] = dp[i][j][k];
                    if(j>=price[i]){
                        dp[i+1][j][k] = Math.max(dp[i+1][j][k], tastiness[i]+dp[i][j-price[i]][k]);
                    }
                    if(k>0 && j>=price[i]/2){
                        dp[i+1][j][k] = Math.max(dp[i+1][j][k], tastiness[i]+dp[i][j-price[i]/2][k-1]);
                    }
                }
            }
        }
        return dp[n][maxAmount][maxCoupons];
    }
}