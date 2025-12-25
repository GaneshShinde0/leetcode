class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int inc = 0,n=happiness.length;
        for(int i=n-1;i>=n-k;i--){
            res+=Math.max(happiness[i]-inc,0);
            inc++;
        }
        return res;
    }
}