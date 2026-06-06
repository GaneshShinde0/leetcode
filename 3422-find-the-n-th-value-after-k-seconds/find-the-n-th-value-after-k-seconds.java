class Solution {
    private final int MOD = 1_000_000_007;
    public int valueAfterKSeconds(int n, int k) {
        long[] a = new long[n];
        Arrays.fill(a,1);
        for(int i=0;i<k;i++){
            long sum =0;
            for(int j=0;j<n;j++){
                sum+=a[j];
                a[j]=(sum%MOD);
            }
        }
        return (int) (a[n-1]%MOD);
    }
}