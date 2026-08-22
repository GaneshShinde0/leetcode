/*
If we look at constraints, this problem looks great for dynamic programming.
1 <= n <= 5000
rollMax.length == 6
1 <= rollMax[i] <= 15

States can be 
    - i: the current roll index(from 0 to n-1, or counting down from n to 0).
    - lastFace: The face of the die we rolled in the previous step (1 to 6).
    - consecutiveCount: HHow many time lastFace has appeared consecutively right before this roll.

Transitions:
    - For the current state(i, lastFace, consecutiveCount), we loop through next choices Face from 1 to 6.
        - If face == lastFace: We can only roll this if consecutiveCount<rollMax[face-1]. If Valid, we transition to (i+1, face, consecutiveCount+1)
        - If face!= lastFace: We can always roll this. The consecutive count resets, so we transition to (i+1, face, 1).

Base case:
    - SInce our DP function is exploring all valid branches one by one, when we succesfully make n valid rolls, we have found 1 valid sequence. Therefore, if i==n, we should return 1, not 6^n. (The DP automatically adds up all these 1s to give the final total).



*/
class Solution {

    private int MOD = 1_000_000_007;

    Integer[][][] memo;
    int[] rollMax;
    int n;

    public int dieSimulator(int n, int[] rollMax) {
        this.memo = new Integer[n+1][7][16];
        this.n = n;
        this.rollMax = rollMax;
        return solve(0, 0, 0);
    }

    private int solve(int currTurn, int lastFace, int consecutiveCount){
        if(currTurn==n) return 1;
        if(memo[currTurn][lastFace][consecutiveCount]!=null) return memo[currTurn][lastFace][consecutiveCount];
        int res = 0;
        for(int face = 1; face<=6; face++){
            if(face==lastFace){
                if(consecutiveCount<rollMax[face-1]) res = (res+solve(currTurn+1, lastFace, consecutiveCount+1))%MOD;
            }else{
                res = (res+solve(currTurn+1, face, 1))%MOD;
            }
        }
        memo[currTurn][lastFace][consecutiveCount] = res;
        return res;
    }
}