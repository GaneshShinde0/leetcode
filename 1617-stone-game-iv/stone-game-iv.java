class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int k=1;k<=n;k++){
            for(int i=1;i*i<=k;i++){
                if(!dp[k-i*i]){
                    dp[k] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    private boolean recurse(HashMap<Integer,Boolean> memo, int n){
        if(memo.containsKey(n)) return memo.get(n);
        if(n==0) return false;
        boolean res = false;
        for(int i=1;i*i<=n;i++){
            res |= !recurse(memo,n-i*i);
            if(res) break; // This condition alone changes time from 1200 to 360 ms
        }
        memo.put(n,res);
        return res;
    }
}
class SolutionInitial {
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return recurse(memo, n);
    }
    private boolean recurse(HashMap<Integer,Boolean> memo, int n){
        if(memo.containsKey(n)) return memo.get(n);
        if(n==0) return false;
        boolean res = false;
        for(int i=1;i<=Math.sqrt(n);i++){
            res |= !recurse(memo,n-i*i);
            if(res) break; // This condition alone changes time from 1200 to 360 ms
        }
        memo.put(n,res);
        return res;
    }
}