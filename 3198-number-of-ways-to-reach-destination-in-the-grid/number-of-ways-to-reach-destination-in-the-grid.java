class Solution {
    public int numberOfWays(int n, int m, int k, int[] source, int[] dest) {
        //         total,   out,     in1      in2     fineIn   toDestIn2steps
        // out     (m+n-2), m+n-4,   1        1       0        2
        // in1     (m+n-2), n-1,     m-2      0       1        m-2
        // in2     (m+n-2), m-1,     0        n-2     1        n-2
        // fineIn  (m+n-2), 0,       m-1,     n-1     0        m+n-2
        
        int mod = 1000000007;
        long o = 0, i1 = 0, i2 = 0, f = 0;
        if (source[0] == dest[0] && source[1] == dest[1]) f++;
        else if (source[0] == dest[0]) i1++;  
        else if (source[1] == dest[1]) i2++;
        else o++;
        if (k == 1) return (int)(i1+i2);

        for (int j = 0; j < k - 2; j++) {
            long oo = o*(m+n-4)%mod, oi1 = o, oi2 = o;
            long i1o = i1*(n-1)%mod, i1i1 = i1*(m-2)%mod, i1f = i1;
            long i2o = i2*(m-1)%mod, i2i2 = i2*(n-2)%mod, i2f = i2;
            long fi1 = f*(m-1)%mod, fi2 = f*(n-1)%mod;

            o = ((oo + i1o)%mod + i2o)%mod;
            i1 = ((oi1 + i1i1)%mod + fi1)%mod;
            i2 = ((oi2 + i2i2)%mod + fi2)%mod;
            f = (i1f + i2f)%mod;
        }

        long res = 0;
        res = (res + o*2)%mod;
        res = (res + i1*(m-2)%mod)%mod;
        res = (res + i2*(n-2)%mod)%mod;
        res = (res + f*(m+n-2)%mod)%mod;
        
        return (int) (res);
    }
}