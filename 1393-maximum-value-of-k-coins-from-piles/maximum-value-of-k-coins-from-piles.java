class Solution {
    int[][] dp = new int[1001][2001];
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // DP
        int n = piles.size();
        return checkRemainingPiles(n-1,k,piles);
    }

    private int checkRemainingPiles(int currentPile, int coinsLeft, List<List<Integer>> piles){
        if(currentPile<0||coinsLeft==0) return 0;
        int ans = dp[currentPile][coinsLeft];
        if(ans!=0) return ans;
        int sumOfValuesFromTop = 0;
        for(int i=0;i<=piles.get(currentPile).size() && i<=coinsLeft; i++){
            ans = Math.max(ans, checkRemainingPiles(currentPile-1,coinsLeft-i,piles)+sumOfValuesFromTop);
            if(i<piles.get(currentPile).size()) sumOfValuesFromTop +=piles.get(currentPile).get(i);
        }
        dp[currentPile][coinsLeft]=ans;
        return ans;
    }
}