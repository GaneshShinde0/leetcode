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
        // dp0[j]: The Number of valid arrays ending with the value 'j' where last move was decreasing (i.e. prevValue>j).
        int[] dp0 = new int[r+1];
        // dp1[j]: The Number of valida arrays ending with the value 'j' where last move was increasing (i.e. prevValue<j)
        int[] dp1 = new int[r+1];

        // Sum0 and sum1 are Prefix Sum Arrays for dp0 and dp1.
        // Sum0[j] will store the sum of dp0[k] for all k from l upto J.
        // We use r+2 to safely handle out of bounds requests when j = r.
        int[] sum0 = new int[r+2];
        int[] sum1 = new int[r+2];

        // Base Case: Array of length 1.
        for(int i=l; i<=r; i++){
            dp0[i]=1; // 1 valid way to have an array of length 1 ending in 'i'
            dp1[i]=1; // 1 valid way to have an array of length 1 ending in 'i'

            // Initializing the prefix sums for length 1.
            sum0[i] = i-l+1; 
            sum1[i] = i-l+1;
        }

        // DP Transition: Build the array lengh by length from 2 upto N
        for(int i=1;i<n;i++){
            // Step 1: Calculate the new DP values for the current length.
            for(int j=l; j<=r;j++){
                // We want to DECREASE to 'j'.
                // Rule: Previous move must have been an INCREASE dp(1)
                // Rule: Previous value 'k' must be strictly GREATER than 'j' (k>j).
                // So we need the sum of dp1[k] for k fromm (j+1) to r.
                // Using prefix sum: Total Sum upto 'r' MINUS sum upto 'j'
                dp0[j] = (sum1[r]-sum1[j]+MOD)%MOD;

                // We want to INCREASE to 'j'
                // Rule: Previous Move must have been a Decrease (dp0).
                // Rule: Previous value 'k' must be strictly less than 'j' (k<j).
                // So we need the sum of dp0[k] for k from 'l' to (j-1)
                // Using prefix sum: THis is exactly the prefix sum upto (j-1).
                dp1[j] = sum0[j-1];
            }

            // Step 2: Update Prefix Sums for the NEXT iteration (Rolling Array Optimization)
            sum0[l] = dp0[l];
            sum1[l] = dp1[l];
            for(int j = l+1;j<=r;j++){
                // Current Prefix Sum = Previous Prefix Sum + Current DP Value.
                sum0[j] = (sum0[j-1]+dp0[j])%MOD;
                sum1[j] = (sum1[j-1]+dp1[j])%MOD;
            }
        }
        // Final Answer the total valid arrays of length n ending in any value between l and r.
        // Since sum0[r] holds the sum of all dp0[j] and sum1[r] for dp1[j].
        // We add them together to get the total valid configurationns.
        return (sum0[r]+sum1[r])%MOD;
    }
}