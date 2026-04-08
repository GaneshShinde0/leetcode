class Solution {
    private static final int MOD = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int result = 0;
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];
            for(int j=l;j<=r;j+=k){
                nums[j]=(int)((1l*nums[j]*v)%MOD);
            }
        }
        for(int num:nums){
            result^=num;
        }
        return result;
    }
}