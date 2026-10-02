class Solution {
    public int function(int i, int j, int[] arr, int[][] dp){
        if (i >= j){
            return 1;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int min_val = Integer.MAX_VALUE;

        if (arr[i] == arr[j]){
            min_val = function(i+1,j-1,arr,dp);
        }

        for (int k = i; k < j; k++){
            min_val = Math.min(min_val,function(i,k,arr,dp)+function(k+1,j,arr,dp));
        }

        dp[i][j] = min_val;

        return min_val;
    }

    public int minimumMoves(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return function(0,n-1,arr,dp);
    }
}