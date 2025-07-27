class Solution {
    public int minimumTotalInitialSolution(List<List<Integer>> triangle) {
        for(int i=triangle.size()-1;i>0;i--){
            List<Integer> li = triangle.get(i);
            for(int j=0;j<li.size()-1;j++){
                Integer temp = Math.min(li.get(j),li.get(j+1))+triangle.get(i-1).get(j);
                triangle.get(i-1).set(j,temp);
            }
        }
        return (int) triangle.get(0).get(0);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
}