class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private static final int MOD = 1_000_000_007;
    int maxMove;
    int m,n;
    int[][][] memo;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove==0) return 0;
        this.m = m;
        this.n = n;
        this.maxMove = maxMove;
        this.memo = new int[m][n][maxMove+1];
        for(int[][] arr:memo){
            for(int[] a:arr) Arrays.fill(a,-1);
        }
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{startRow, startColumn, 0});
        HashMap<String, Long> hm = new HashMap<>();
        dfs(startRow,startColumn, 0, hm);
        return memo[startRow][startColumn][0];
    }
    private int dfs(int row, int col, int currMoves, HashMap<String, Long> hm){
        if(memo[row][col][currMoves]!=-1){
            return memo[row][col][currMoves]%MOD;
        }
        int count = 0;
        if(currMoves == maxMove) return 0;
        for(int[] dir:dirs){
            int newR = row+dir[0];
            int newC = col+dir[1];
            if(newR<0||newC<0||newR>=m||newC>=n){
                count = (count+1)%MOD;
                continue;
            }
            count = (count+dfs(newR,newC, currMoves+1, hm))%MOD;
        }
        return memo[row][col][currMoves] = count;
    }
}
class SolutionDFSTLE {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private static final int MOD = 1_000_000_007;
    int res;
    int maxMove;
    int m,n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.res = 0;
        this.m = m;
        this.n = n;
        this.maxMove = maxMove;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{startRow, startColumn, 0});
        HashMap<String, Integer> hm = new HashMap<>();
        dfs(startRow,startColumn, 0, hm);
        return res;
    }
    private void dfs(int row, int col, int currMoves, HashMap<String, Integer> hm){
        if(hm.containsKey(row+","+col+","+currMoves)){
            res += hm.get(row+","+col+","+currMoves);
            return;
        }
        if(currMoves == maxMove) return;
        for(int[] dir:dirs){
            int newR = row+dir[0];
            int newC = col+dir[1];
            if(newR<0||newC<0||newR>=m||newC>=n){
                res = (res+1)%MOD;
                hm.put(newR+","+newC+","+currMoves+1, res);
                continue;
            }
            dfs(newR,newC, currMoves+1, hm);
        }
    }
}
