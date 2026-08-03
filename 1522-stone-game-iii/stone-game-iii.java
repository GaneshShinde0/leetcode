/*
Let n denote the number of stones in the row.

For 0<=i<=n, define dp[i] as follow. Consider a game with only the last n-i stones (imagine stoneValues[i] is the first stone). dp[i] is the first player's score minus the second players socre at the end of the game.

The base case of this DP is dp[n] = 0. Since there are no stones in the game, thus the players cannot make any moves, and the differece between their scores will be zero.

Consider now i<n when at least one stone is in the game. Let's call the first player X and second one Y. THen dp[i] is the difference score[x]-score[y]

- If the player X takes 1 stone (with index i), X's score for the current move is stoneValue[i]. After that, the next state will be dp[i+1], since there is one less stone in the game. However, the players exchange their roles X becomes Y, and Y becomes X.

- We defined dp[i] as scoreX - scoreY. Thus, dp[i+1] is actually the future value of scoreY-scoreX from the perspective of dp[i], since X and Y have swapped.

- Thus, if player X only takes 1 stone, then it will result in a score difference of stoneValue[i]-dp[i+1]. The minus is to flip scoreY- scoreX into scoreX - scoreY.

- Similarly, if X takes two stones(with indices i and i+1), the difference scoreX - scoreY will be stoneValue[i] + stoneValue[i+1]-dp[i+1]

- Finally, if X takes three stones, the difference will be stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - dp[i+3].

Since X plays optimally, they will choose the option that maximizes the difference scoreX-scoreY. It implies that dp[i] is the maximum of the above three values. (Try all three).

Having all DP values computed, one can answer who wins using only dp[0], which is the score difference in the game with all n stones present. Since Alice is the first player, this value being positive means Alice wins.

Algorithm:
1. Let n be number of stones.
2. Declare the array dp of size n+1.
3. Set dp[n] = 0. (The base case of the DP).
4. Iterate i from n-1 to 0.
    - Set dp[i] = stoneValue[i] - dp[i+1]
    - if i+2 <= n, update dp[i] with stoneValue[i] + stoneValue[i+1] - dp[i+2] (Take two stones) if its larger.
    - if i+3 <= n, update dp[i] with stoneValue[i] + stoneValue[i+1] + stoneValue[i+3] - dp[i+3] (Take three stones) if they are larger.
5. if dp[0]>0 Alice wins.
6. if dp[0]<0 Bob Wins.
7. if dp[0]=0 Tie.
*/
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            dp[i] = stoneValue[i] - dp[i+1];
            if(i+1<n) dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i+1]-dp[i+2]);
            if(i+2<n) dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - dp[i+3]);
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        else return "Tie";
    }
}