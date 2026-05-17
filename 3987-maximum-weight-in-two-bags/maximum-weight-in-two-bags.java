/*
## Intuition:
Use DP, each item can be put either in bag 1 or 2, and it can only be put if there is still capacity for it and can transfer from past valid state. From constraints, we can easily enumerate all possible combinations and find the maximum among all the commbos

*/
class Solution {
    public int maxWeight(int[] weights, int w1, int w2) {
        int n = weights.length;
        boolean[][] f = new boolean[w1+1][w2+1];
        boolean[][] g = new boolean[w1+1][w2+1];
        f[0][0] = true;
        int res = 0;
        for(int x:weights){
            for(int i=0;i<=w1;i++){
                g[i] = f[i].clone();
            }
            for(int i=x;i<=w1;i++){
                for(int j=0;j<=w2;j++){
                    if(g[i-x][j]){
                        res = Math.max(res,i+j);
                        f[i][j] = true;
                    }
                }
            }
            for(int j = x;j<=w2;j++){
                for(int i=0;i<=w1;i++){
                    if(g[i][j-x]){
                        res = Math.max(res, i+j);
                        f[i][j] = true;
                    }
                }
            }
        }
        return res;
    }
}