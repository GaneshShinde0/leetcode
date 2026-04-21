class Solution {
    public int maxSatisfactionInitial(int[] satisfaction) {
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

    public int maxSatisfaction(int[] satisfaction){
        Arrays.sort(satisfaction);
        int res = 0, total = 0, n = satisfaction.length;
        for(int i = n-1; i>=0 && satisfaction[i]+total>0;i--){
            total += satisfaction[i];
            res += total;
        }
        return res;
    }
}