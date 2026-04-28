class Solution {
    public int countLatticePoints(int[][] circles) {
        boolean[][] vis = new boolean[201][201];
        int res = 0;
        for(int[] circle:circles){
            int x = circle[0], y = circle[1], r = circle[2];
            for(int i=x-r;i<=x+r;i++){
                for(int j=y-r;j<=y+r;j++){
                    if(!vis[i][j] && (i-x)*(i-x)+(j-y)*(j-y)<=r*r){
                        vis[i][j]=true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}