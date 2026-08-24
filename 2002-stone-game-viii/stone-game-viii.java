class Solution{
    public int stoneGameVIII(int[] stones){
        int n = stones.length;
        int totalPrefixSumSoFar = 0;
        for(int s:stones) totalPrefixSumSoFar += s;
        int maxDifferenceSoFar = Integer.MIN_VALUE; // Taking min as we have negative elements, This is just a reference of thought process.
        maxDifferenceSoFar = totalPrefixSumSoFar; // But Initially we will have total prefixSum as maxDifference (Alice Takes All)
        for(int i = n-2;i>=1;i--){
            totalPrefixSumSoFar -= stones[i+1]; // i+1 lets take elements until i only
            maxDifferenceSoFar = Math.max(maxDifferenceSoFar, totalPrefixSumSoFar-maxDifferenceSoFar);
        }
        return maxDifferenceSoFar;
    }
}
class SolutionONSpace {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+stones[i];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n-1] = prefixSum[n-1];
        for(int i=n-2;i>=1;i--){
            dp[i] = Math.max(dp[i+1],prefixSum[i]-dp[i+1]);
        }
        return dp[1];
    }
}