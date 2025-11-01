class Solution {

    private static final int N = 201;
    private long[][] dp = new long[N][N];
    public long sellingWood(int m, int n, int[][] prices) {
        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int[][] price = new int[m+1][n+1];
        for(int[] p:prices){
            price[p[0]][p[1]]=p[2];
        }
        return maxPrice(m,n,price);
    }

    private long maxPrice(int rows, int cols, int[][] prices){
        if(rows ==1 && cols ==1 ) return prices[rows][cols];

        long ans = dp[rows][cols];
        if(ans!=-1) return ans;
        ans = prices[rows][cols];
        for(int row = 0;row<rows/2;row++){
            ans = Math.max(ans, maxPrice(row+1,cols,prices)+maxPrice(rows-row-1,cols,prices));
        }
        for(int col=0;col<cols/2;col++){
            ans = Math.max(ans, maxPrice(rows,col+1,prices)+maxPrice(rows,cols-col-1,prices));
        }
        dp[rows][cols] = ans;
        return ans;
    }
}