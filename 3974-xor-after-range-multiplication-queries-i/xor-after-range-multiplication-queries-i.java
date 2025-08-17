class Solution {
    private static final int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query:queries){
            int idx = query[0];
            int r = query[1];
            for(int i=idx;i<=r;i+=query[2]){
                long l =(1l*nums[i]*query[3])%MOD; 
                nums[i]=(int) l;
            }
        }
        int res =0;
        for(int i:nums){
            res^=i;
        }
        return res;
    }
}