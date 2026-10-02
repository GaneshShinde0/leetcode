class Solution {
    public int houseOfCards(int n) {
        //Coin Change where each coin can be used only once in one way. Cannot duplicate coins in the particular way. Can be used in other ways.
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=2;i<=n;i+=3) //Cards Needed //Coins
        {
            for(int j=n;j>=i;j--) //Total Cards //Sum //Note: Iterate from last to remove duplicates 
            {
                if(i<=j) 
                {
                   dp[j] += dp[j-i];
                } 
              //  System.out.print(dp[j]+" ");
            }
           // System.out.println("");
        }

        return dp[n];
    }
}
