class Solution {
    public long flowerGameTLE(int n, int m) {
        int res =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((i+j)%2==1) res++;
            }
        }
        return res;
    }

    public long flowerGame(int n, int m) {
        return ((long) m * n) / 2;
    }
}