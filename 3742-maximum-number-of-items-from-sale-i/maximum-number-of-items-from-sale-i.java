class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCounts = new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(i!=j && items[j][0]%items[i][0]==0){
                    count++;
                }
            }
            freeCounts[i] = count;
        }
        int[] dp = new int[budget+1];
        for(int i=0;i<n;i++){
            int cost = items[i][1];
            int firstCopyValue = 1+freeCounts[i];
            int nextCopyValue = 1;
            int[] newDP = Arrays.copyOf(dp,budget+1);
            for(int w = cost; w<=budget;w++){
                newDP[w] = Math.max(newDP[w],dp[w-cost]+firstCopyValue);
                newDP[w] = Math.max(newDP[w], newDP[w-cost]+nextCopyValue);
            }
            dp = newDP;
        }
        return dp[budget];
    }
}