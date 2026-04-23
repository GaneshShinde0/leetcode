class Solution {
    int res  = 0;
    public int tallestBillboardTLE(int[] rods) {
        backtrackTLE(rods,0,0,0);
        return res;
    }

    private void backtrackTLE(int[] rods, int i, int total1, int total2){
        if(total1==total2) res = Math.max(res, total1);
        if(i==rods.length) return;
        backtrackTLE(rods,i+1,total1+rods[i],total2);
        backtrackTLE(rods,i+1,total1,total2+rods[i]);
        backtrackTLE(rods,i+1,total1,total2);
    }

    private static final int MIN_VAL = -10000;

    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[][] memo = new int[n][5001];
        for(int[] m:memo) Arrays.fill(m,-1);
        int result = backtrack(rods,0,0,memo);
        return result<0?0:result;
    }

    private int backtrack(int[] rods, int i, int diff, int[][] memo){
        if(i==rods.length) return diff == 0?0:MIN_VAL;
        if(memo[i][diff]!=-1) return memo[i][diff];

        int curr = rods[i];

        // Skip
        int res = backtrack(rods, i+1, diff, memo);

        // Add to taller side
        if(diff+curr<=5000) res = Math.max(res, backtrack(rods,i+1,diff+curr, memo));

        // Add to shorter side, Decreases or flips diff.
        // Gain is the height added to the shorter pile.
        int choice3 = backtrack(rods,i+1,Math.abs(diff-curr),memo)+ Math.min(diff, curr);
        res = Math.max(res,choice3);
        
        return memo[i][diff]=res;
    }
}