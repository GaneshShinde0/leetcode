class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> Integer.compare(a[0],b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp,1);
        for(int i=0;i<pairs.length;i++){
            for(int j=i+1;j<pairs.length;j++){
                if(pairs[j][0]>pairs[i][1]){
                    dp[j] = Math.max(dp[j],1+dp[i]);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}