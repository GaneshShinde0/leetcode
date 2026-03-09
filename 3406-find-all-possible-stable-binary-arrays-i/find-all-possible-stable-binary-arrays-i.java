/*
Test Case Generation:

Test Case 1:
Input: zero = 1, one = 1, limit = 2
Arrays length will be zero + one => 1+1=>2
Limit is 2=> So each subarray with length 3 should have both zero and one.
Arrays of length 2 => [0,0], [0,1], [1,0], [1,1]
Array satisfying our conditions [0,1],[1,0]
Result = 2;

Test Case 2:
Input: zero = 3, one = 3, limit = 2
Array Length will be zero+one => 3+3=> 6
Limit is 2 => So easy subarry with length 3 should have both zero and one.


The input constraints are as follows: 1 <= zero, one, limit <= 200
It is not possible to create all the combinations and check because of input constaints.

Might need a DP which will save result of previous states and we can use all previous combinations based on zero one and limit.

## Intuition
The problem requires that every subarray of lenght  greater than limit in the binary array arr contains both 0 and 1. This condition is equivalent to requiring that every subarray of length exactly limit+1 contians both 0 and 1.

- let dp[i][j][0] denote the number of valid schemes in which we have used i zeros and j ones, and the last placed number is 0.
- let dp[i][j][1] denote the number of valid schemes in which we have used i zeros and j ones and last placed number is 1.

## Lets analyze the transition for dp[i][j][0]
- When j = 0 and i in [0, min(zero,limit)], we can keep placing 0s without violating constraint. Thus dp[i][j][0] = 1;
- When i = 0 or when j=0 but i not in [0,min(zero,limit)], no valid scheme exists. Thus dp[i][j][0]=0
- When i>0 and j>0, dp[i][j][0] can be derived from dp[i-1][j][0] and dp[i-1][j][1]:
    - From dp[i-1][j][1]: We can always append a 0 to these schemes, since the previous number was 1.
    - From dp[i-1][j][0]: 
        if i<=limit, appending another 0 does not violate the constaint.
        if i>limit, appending 0 may create more than limit consecutive zeros. In this case we must subtract the invalid schemes where the previous limit elements were all zeros. These correspond to dp[i-limit-1][j][1]

Therefore, the transition for dp[i][j][0] is 

dp[i][j][0] = {1,i in [0, min(zero,limit)], j=0 dp[i-1][j][0]+dp[i-1][j][0]-dp[i-limit-1][j][1], i>limit, j>0 dp[i-1][j][1]+dp[i-1][j][0], i<= limit, j>0; 0 Otherwise}

Similarly transition for dp[i][j][1] is

dp[i][j][1] = {1, i=0, j in [0, min(one, limit)] dp[i][j-1][0]+ dp[i][j-1][1]-dp[i][j-limit-1][0], i>0, j>imit dp[i][j-1][0]+ dp[i][j-1][1], i>0, j<=limit 0, Otherwise}


Total Number of stable binary arrays is 
dp[zero][one][0]+dp[zero][one][1]


*/

class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero+1][one+1][2];
        for(int i=0;i<=Math.min(zero, limit);i++){
            dp[i][0][0] = 1;
        }
        for(int j=0;j<=Math.min(one,limit);j++){
            dp[0][j][1] = 1;
        }
        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                if(i>limit){
                    dp[i][j][0] = dp[i-1][j][0] +dp[i-1][j][1]- dp[i-limit-1][j][1];
                }else{
                    dp[i][j][0] = dp[i-1][j][0]+dp[i-1][j][1];
                }

                dp[i][j][0] = ((dp[i][j][0]%MOD)+MOD)%MOD;

                if(j>limit){
                    dp[i][j][1] = dp[i][j-1][1]+dp[i][j-1][0]-dp[i][j-limit-1][0];
                }else{
                    dp[i][j][1] = dp[i][j-1][1]+dp[i][j-1][0];
                }

                dp[i][j][1] = ((dp[i][j][1]%MOD)+MOD)%MOD;
            }
        }
        return (int) (dp[zero][one][0]+dp[zero][one][1])%MOD;
    }
}