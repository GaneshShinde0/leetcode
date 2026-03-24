class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n-1)%(k-1)>0) return -1;
        int[] prefix = new int[n+1];
        for(int i=0;i<n;i++) prefix[i+1]=prefix[i]+stones[i];

        int[][] dp = new int[n][n];
        for(int m=k;m<=n;++m){
            for(int i=0;i+m<=n;++i){
                int j = i+m-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int mid = i;mid<j;mid+=k-1){
                    dp[i][j] = Math.min(dp[i][j],dp[i][mid]+dp[mid+1][j]);
                }
                if((j-i)%(k-1)==0) dp[i][j] += prefix[j+1]-prefix[i];

            }
        }
        return dp[0][n-1];
        
    }
}

/*
Input: stones = [3,2,4,1], k = 2

[1,2,3,4]

[3,3,4] cost = 3
[6,4] cost = 9
[10] cost = 19




Question asks k-consecutive, then it will have (n-k)! with bruteforce.


Intuition: Most of the games, especially stone games, are solved by dp.

Explaination:
dp[i][j] means cost needed to merge stone[i] -> stone[j] into m piles.

Initial status dp[i][i][1] = 0 and dp[i][i] = infinity
dp[i][j][1] = dp[i][j][k]+stonesNumber[i][j]
dp[i][j] = Math.min(dp[i][mid][1]+dp[mid+1][m-1])
*/