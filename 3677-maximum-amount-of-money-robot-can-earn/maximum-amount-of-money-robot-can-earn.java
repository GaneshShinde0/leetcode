/*
DP on Grids.
*/
class Solution {
    int[][] dirs = { { 1, 0 }, { 0, 1 } };

    public int maximumAmountTLE(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int res = Integer.MIN_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(
                new int[] { 0, 0, coins[0][0], coins[0][0] >= 0 ? coins[0][0] : 0, coins[0][0] < 0 ? coins[0][0] : 0 }); // max and secondmax
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            int currRes = current[2];
            if (i == m - 1 && j == n - 1) {
                if (current[3] < 0)
                    currRes -= current[3];
                if (current[4] < 0)
                    currRes -= current[4];
                res = Math.max(res, currRes);
            }
            for (int[] dir : dirs) {
                int newI = dir[0] + i;
                int newJ = dir[1] + j;
                if (newI < 0 || newJ < 0 || newI >= m || newJ >= n)
                    continue;
                int currCoin = coins[newI][newJ];

                // Create local copies so one direction doesn't corrupt the other
                int s1 = current[3]; // second smallest
                int s2 = current[4]; // smallest (most negative)
                if (currCoin < s2) {
                    s1 = s2;
                    s2 = currCoin;
                } else if (currCoin < s1) {
                    s1 = currCoin;
                }
                queue.offer(new int[] { newI, newJ, currRes + currCoin, s1, s2 });
            }
        }
        return res;
    }

    /*
    Approach 2:
    At Each Cell
    1. Take That Cell
        Money = coins[i][j]+Max(solve(i,j+1,neu),solve(i+1,j,neu));
    2. Skip That cell
        2.1 (coins[i][j]<0 && neutralization>0){
            right = solve(i+1,j,neu-1);
            down = solve(i,j+1,neu-1);
        }
        skip = max(right,down);
    */
    int m;
    int n;
    int dp[][][];
    public int maximumAmount(int[][] coins) {
        this.m = coins.length;
        this.n = coins[0].length;
        this.dp = new int[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return solve(coins,0,0,2);
    }
    
    private int solve(int[][] coins, int i, int j, int neu){
        if(i==m-1 && j==n-1){
            if(coins[i][j]<0 && neu>0) return 0;
            return coins[i][j];
        }
        if(i>=m||j>=n) return Integer.MIN_VALUE;
        if(dp[i][j][neu]!=Integer.MIN_VALUE) return dp[i][j][neu];
        // Take current cell value;
        int take = coins[i][j] + Math.max(solve(coins,i+1,j,neu),solve(coins,i,j+1,neu));
        int skip = Integer.MIN_VALUE;
        if(coins[i][j]<0 && neu>0){
            int skipRight = solve(coins,i+1,j,neu-1);
            int skipDown = solve(coins,i,j+1,neu-1);
            skip = Math.max(skipRight,skipDown);
        }
        dp[i][j][neu]=Math.max(take,skip);
        return Math.max(take,skip);
    }
    public int maximumAmountWihtoutDP(int[][] coins) {
        this.m = coins.length;
        this.n = coins[0].length;
        int[][] dp = new int[m][n];
        return solveWithoutDP(coins,0,0,2);
    }

    private int solveWithoutDP(int[][] coins, int i, int j, int neu){
        if(i==m-1 && j==n-1){
            if(coins[i][j]<0 && neu>0) return 0;
            return coins[i][j];
        }
        if(i>=m||j>=n) return Integer.MIN_VALUE;
        // Take current cell value;
        int take = coins[i][j] + Math.max(solveWithoutDP(coins,i+1,j,neu),solveWithoutDP(coins,i,j+1,neu));
        int skip = Integer.MIN_VALUE;
        if(coins[i][j]<0 && neu>0){
            int skipRight = solveWithoutDP(coins,i+1,j,neu-1);
            int skipDown = solveWithoutDP(coins,i,j+1,neu-1);
            skip = Math.max(skipRight,skipDown);
        }
        return Math.max(take,skip);
    }
}

/*
[
 [0,1,-1]
 [1,-2,3]
 [2,-3,4]
]
*/