class Solution {
    private int dx[]={-1,0,-1};
    private int dy[]={0,-1,-1};
    private static int MOD=(int)1e9+7;
    public int[] pathsWithMaxScore(List<String> board) {
        int r=board.size(),c=board.get(0).length();
        char[][] grid=new char[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                grid[i][j]=board.get(i).charAt(j);
            }
        }

        int[][] dp=new int[r][c];
        int[][] ways=new int[r][c];
        ways[r-1][c-1]=1;

        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{r-1,c-1,0});//at (r-1,c-1) sum is 0
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0],y=cur[1],sum=cur[2];

            for(int i=0; i<3; i++){
                int nx=x+dx[i],ny=y+dy[i];
                if(nx>=0 && ny>=0){
                    char ch=grid[nx][ny];
                    if(ch=='X')continue;
                    int newSum=ch=='E'?sum:sum+ch-'0';
                    if(newSum>dp[nx][ny]){
                        dp[nx][ny]=newSum;
                        q.add(new int[]{nx,ny,newSum});
                        ways[nx][ny]=ways[x][y];
                    }else if(newSum==dp[nx][ny]){
                        ways[nx][ny]=(ways[nx][ny]+ways[x][y])%MOD;
                    }
                }
            }
        }
        int[] ans={dp[0][0],ways[0][0]};
        return ans;
    }
}