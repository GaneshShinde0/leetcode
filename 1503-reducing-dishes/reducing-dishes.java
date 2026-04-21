class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int res = 0;
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        for(int i=0;i<n;i++){
            int sum = 0;
            int k = 1;
            for(int j=i;j<n;j++){
                sum+=k*satisfaction[j];
                k++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}