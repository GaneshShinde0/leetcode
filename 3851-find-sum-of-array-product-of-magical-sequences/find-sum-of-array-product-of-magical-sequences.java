class Solution {
    private static final int MOD = 1000000007;
    public long quickmul(long x, long y, long mod){
        long res = 1;
        long cur = x%MOD;

        while(y>0){
            if((y&1)==1){
                res = (res*cur)%MOD;
            }
            y>>=1;
            cur = (cur*cur)%MOD;
        }
        return res;
    }
    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        long[] fac = new long[m+1];
        fac[0]=1;
        for(int i=1;i<=m;i++){
            fac[i]=(fac[i-1]*i)%MOD;
        }
        long[] ifac = new long[m+1];
        ifac[0]=1;
        ifac[1]=1;

        for(int i=2;i<=m;i++){
            ifac[i] = quickmul(i,MOD-2,MOD);
        }

        for(int i=2;i<=m;i++){
            ifac[i]=(ifac[i-1]*ifac[i])%MOD;
        }

        long[][] numsPower = new long[n][m+1];
        for(int i=0;i<n;i++){
            numsPower[i][0]=1;
            for(int j=1;j<=m;j++){
                numsPower[i][j] = (numsPower[i][j-1]*nums[i])%MOD;
            }
        }

        long[][][][] f = new long[n][m+1][m*2+1][k+1];
        for(int j=0;j<=m;j++){
            f[0][j][j][0]=(numsPower[0][j]*ifac[j])%MOD;
        }

        for(int i=0;i+1<n;i++){
            for(int j=0;j<=m;j++){
                for(int p=0;p<=m*2;p++){
                    for(int q = 0;q<=k;q++){
                        int q2 = (p%2)+q;
                        if(q2>k) break;
                        for(int r=0;r+j<=m;r++){
                            int p2 = p/2+r;
                            f[i+1][j+r][p2][q2] +=  (((f[i][j][p][q]*numsPower[i+1][r])%MOD)*ifac[r])%MOD;
                            f[i+1][j+r][p2][q2]%=MOD;
                        }
                    }
                }
            }
        }

        long res = 0;
        for(int p=0;p<=m*2;p++){
            for(int q=0;q<=k;q++){
                if((Integer.bitCount(p)+q)==k){
                    res = (res+((f[n-1][m][p][q]*fac[m])%MOD))%MOD;
                }
            }
        }
        return (int) res; 
    }
}