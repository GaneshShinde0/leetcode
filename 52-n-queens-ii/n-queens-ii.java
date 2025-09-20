class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>(); // (r+c)
    Set<Integer> negDiag = new HashSet<>(); // (r-c)
    int res = 0;
    int n;
    public int totalNQueens(int n) {
        this.n=n;
        backtrack(0);
        return res;
    }
    void backtrack(int r){
        if(r==n){
            res+=1;
            return;
        }
        for(int c=0;c<n;c++){
            if(col.contains(c)||posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            backtrack(r+1);
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
    }   
}