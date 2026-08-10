class Solution {
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
            if(res) break;
        }
        memo.put(n,res);
        return res;
    }
}