class Solution {
    private final int MOD = 1_000_000_007;
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        int[][] comb = new int[n][2];
        for(int i=0;i<nums1.length;i++){
            comb[i][0]= nums1[i];
            comb[i][1]= nums0[i];
        }
        Arrays.sort(comb,(a,b)->{
                // if (a[1] == 0 && b[1] == 0) return 0; // or Integer.compare(b[0], a[0])
                // else if(a[1]==0) return -1;
                // else if(b[1]==0) return 1;
                // else if(a[0]!=b[0]) return Integer.compare(b[0],a[0]);
                // else return Integer.compare(a[1],b[1]);
                if (a[1] == 0 || b[1] == 0) {
                    return Integer.compare(a[1], b[1]);
                } else if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });
        int res = 0;
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(comb[i]));
            int both = comb[i][0]+comb[i][1];
            long current = (pow(2,both)-pow(2,comb[i][1])+MOD)%MOD;
            res = (int) ((shift(res,both)+current)%MOD);
        }
        return res;
    }
    private long pow(long x, long y){
        if(y==0) return 1;
        long pow = pow(x,y/2)%MOD;
        pow = (pow*pow)%MOD;
        if(y%2==0) return pow;
        else return (x*pow)%MOD;
    }
    
    private long shift(int x, int y){
        if(y==0) return x;
        return (x*pow(2,y))%MOD;
    }
}