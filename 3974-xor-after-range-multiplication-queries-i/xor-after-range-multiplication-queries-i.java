class Solution {
    private static final int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query:queries){
            int idx = query[0];
            int r = query[1];
            int k =query[2];
            int v = query[3];
            for(int i=idx;i<=r;i+=k){
                nums[i]=(int) ((1l*nums[i]*v)%MOD);
            }
        }
        int res =0;
        for(int i:nums){
            res^=i;
        }
        return res;
    }
}