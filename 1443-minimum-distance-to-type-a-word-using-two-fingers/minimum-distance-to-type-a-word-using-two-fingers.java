/*
Minimum Distance to Type a Word Using Two Fingers.

Approach 1: Dynamic Programming
We define dp[i][j][k] as the minimum distance required to reach a state where, after typing ith character of the string word, the left hand is at position l and right hand is at position r. Here, the position refers tot the index of the character, For example, A corresponds to 0, B =>1 and so on. This representation maps characters to integers instead of using 2D keyboard co-ordinates, which simplifies state transitions.

Now, How do we perform state transitions?

We first observe an important property: For any state dp[i][j][k], either word[i]=l or word[i]=r. In other words, after typing ith character, atleast one of the hands must be at the position of word[i].

We consider the transition based on these two cases.
- When word[i]=l, the left hand is at position of word[i]. We consider where the i-1th character was typed.
    - If the left hand was at word[i-1], then it moves from word[i-1] to word[i]
*/
class SolutionApproach1 {

    private int getDistance(int p, int q){
        int x1 = p/6, y1=p%6;
        int x2 = q/6, y2=q%6;
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n][26][26];
        for(int[][] dp2d:dp){
            for(int[] dp1d:dp2d) Arrays.fill(dp1d,Integer.MAX_VALUE/2);
        }
        
        // Setting all the characters first typed by any finger to 0.
        for(int i=0;i<26;i++){
            dp[0][i][word.charAt(0)-'A']=0;
            dp[0][word.charAt(0)-'A'][i]=0;
        }

        for(int i=1; i<n; i++){
            int curr = word.charAt(i)-'A';
            int prev = word.charAt(i-1)-'A';
            int d= getDistance(prev,curr);

            for(int j=0;j<26;j++){
                dp[i][curr][j] = Math.min(dp[i][curr][j],dp[i-1][prev][j]+d);
                dp[i][j][curr] = Math.min(dp[i][curr][j],dp[i-1][prev][j]+d);

                if(prev == j){
                    for(int k=0; k<26; k++){
                        int d0 = getDistance(k,curr);
                        dp[i][curr][j] = Math.min(dp[i][curr][j], dp[i-1][k][j]+d0);
                        dp[i][j][curr] = Math.min(dp[i][j][curr], dp[i-1][j][k]+d0);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE/2;
        for(int i=0; i<26; i++){
            for(int j=0; j<26; j++){
                ans = Math.min(ans, dp[n-1][i][j]);
            }
        }
        return ans;
    }
}

/*
Approach 2: Dynamic Programming + Space Optimization
- From Approach 1, For any state dp[i][j][k] or dp[i][left][right], either word[i]=l or word[i]=r. This means that for each i, we only need to store 2[x] states instead of [x][x].
- We can redefine the states as dp[i][op][rest], where 
    - op = 0 means the left hand is at word[i].
    - op = 1 means the right hand is at word[i]
    - rest represents the position of the other hand.
- We can simplify this further by observing symmetry. Swapping the roles of the left and right hands does not change the total movement cost. Therefore, dp[i][op=0][rest] and dp[i][op=1][rest] are always equal.

This allows us to reduce the state to dp[i][rest], which represents the minimum movement cost when one hand is at word[i] and the other is at position rest. We no longer need to distinguish between left and right hands.

*/
class Solution {

    private int getDistance(int p, int q){
        int x1 = p/6, y1=p%6;
        int x2 = q/6, y2=q%6;
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[n][26];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }
        Arrays.fill(dp[0],0);
        for(int i=1;i<n;i++){
            int curr = word.charAt(i)-'A';
            int prev = word.charAt(i-1)-'A';
            int d = getDistance(curr,prev);

            for(int j=0;j<26;j++){
                dp[i][j] =Math.min(dp[i][j],dp[i-1][j]+d);
                if(prev == j){ // Already calculated?
                    for(int k=0;k<26;k++){
                        int d0 = getDistance(k,curr);
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+d0);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE/2;
        for(int value:dp[n-1]) ans = Math.min(ans,value);
        return ans;
    }
}