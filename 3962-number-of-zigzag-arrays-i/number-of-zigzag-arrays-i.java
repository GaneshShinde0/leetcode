/*
Input: Three integers n, l, r

ZigZag array of length N is defined as follows
- Each Element lies in the range [l,r]
- No two adjacent elements are equal
- No three consecutive elements form a strictly increasing or decreasing sequence.

Output: Total Number of Valid ZigZag Arrays. (MODULO 10^9+7)

Approach: Dynamic Programming + Prefix Sum Optimization
Intuition:
Problem that involve counting the number of valid sequences are often solved using dynamic programming.

Let the zigzag array be denoted by z, and define dp[i]dir[j] as the number of valid schemes where the length of z is i+1, the relative order of its two elements is represented by dir, and z[i] = j, where l<=j<=r.

Let the last two elements of z be z[i-1] and z[i], We define dir as follows.
- If z[i-1]>z[i], the last two elements form a strictly decreasing pair, so dir = 0.
- If z[i-1]<z[i], the last two elements form a strictly increasing pair, so dir = 1.

Now consider the state transition.

Since the zigzag property depends only on the relative order of adjacent elements, the transition depends solely on the previous state. In other words, the value of dp[i] depeends only on dp[i-1].

Furthermore, according to the definition of a sawtooth array, the direction of two consecutive adjacent pairs mult alternate. Therefore, a state with dir = 0 can only stansition from a state with dir = 1, and vice versa.

for dp[i][0][j], The last two elements must form a strictly decreasing pair. Therefore, the last value j` of the previous state must satisfy j`>j. Similarly, for dp[i][1][j], the last value j` of the previous state must satisfy j`<j. Summing all valid previous states yields the number of schemes for the current state.

This gives the following transition equations. For convenience, we shift the original interval [l,r] to [0,m-1], where m = r-l+1. Some implementation may use the original interval directly but underlying idea remains the same.

dp[i][0][j] = Summation[(k=j+1) to (m-1) dp[i-1][1][k]
dp[i][1][j] = Summation(k=0 to j-1 dp[i-1][0][k])

The two summations above can be optimized using prefix sums.

Let sum[i][dir] denote the prefix-sum array corresponding to states of length i+1 and direction idr. To Simplify boundary handling, we use a prefix-sum array of length m+1 and define.

sum[i][dir][j] = Summation(k=0 to j-1 dp[i][dir][k])

In Particular, 
sum[i][dir][0] = 0;

With Prefix Sums, each state transition can be computed in O(1) time. The optimized transition equation becomes.

dp[i][0][j] = sum[i-1][1][m] - sum[i-1][1][j+1]
dp[i][1][j] = sum[i-1][0][j]

For Initialization, set every element of dp[0] to 1, since there is exactly one valid sequence of length 1 for each possible value.

In the implementation, we split the second dimension of dp into two separate arrays, dp0 and dp1, for simpler indexing. Simmilarly, the second dimension of sum is split into sum0 and sum1.

Notice that the transitions of the dp array depend only on the prefix-sum arrays from the previous iteration, while the prefix-sum array depend only on the current dp arrays. As a result, the first dimension can be removed using a rolling-array technique. Reducing the pace complexity to O(m).

Note: The transition formulas for the two directions are highly symmetric. With additional observation, the implementation can be simplified further by exploring this symmetry.
*/
public class Solution {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int[] dp0 = new int[r+1];
        int[] dp1 = new int[r+1];
        int[] sum0 = new int[r+2];
        int[] sum1 = new int[r+2];

        for(int i=1; i<=r; i++){
            dp0[i]=1;
            dp1[i]=1;
            sum0[i] = i-l+1;
            sum1[i] = i-l+1;
        }

        for(int i=1;i<n;i++){
            for(int j=l; j<=r;j++){
                dp0[j] = (sum1[r]-sum1[j]+MOD)%MOD;
                dp1[j] = sum0[j-1];
            }
            sum0[l] = dp0[l];
            sum1[l] = dp1[l];
            for(int j = l+1;j<=r;j++){
                sum0[j] = (sum0[j-1]+dp0[j])%MOD;
                sum1[j] = (sum1[j-1]+dp1[j])%MOD;
            }
        }
        return (sum0[r]+sum1[r])%MOD;
    }
}