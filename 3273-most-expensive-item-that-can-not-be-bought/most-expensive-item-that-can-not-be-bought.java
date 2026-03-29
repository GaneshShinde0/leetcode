class Solution {
    public int mostExpensiveItemInitial(int primeOne, int primeTwo) {
        return primeOne * primeTwo - primeOne - primeTwo;
    }

    public int mostExpensiveItem(int primeOne, int primeTwo) {
        // The max is always < (primeOne * primeTwo)
        int m = primeOne*primeTwo;

        /* Dp array stores number of minimum number of coins needed to sum up to the amount from 0 to m-1 */
        int dp[] = new int[m];

        Arrays.fill(dp, m);
        dp[0]=0;

        for(int i=Math.min(primeOne, primeTwo);i<m;i++){
            if(primeOne<=i)
                dp[i] = Math.min(dp[i], dp[i-primeOne]+1);
            if(primeTwo<=i)
                dp[i] = Math.min(dp[i], dp[i-primeTwo]+1);
        }

        // Finding the highest index with value that didnt change i.e. is m
        for(int i=m-1;i>=0;i--){
            if(dp[i]==m){
                return i;
            }
        }
        return -1;
    }
}