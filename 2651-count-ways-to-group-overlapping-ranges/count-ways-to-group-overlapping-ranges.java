class Solution {
    private static final int MOD = 1_000_000_007;
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges,(a,b)->Integer.compare(a[0],b[0]));
        int result = 1, end= Integer.MIN_VALUE;
        for(int i=0;i<ranges.length;i++){
            if(ranges[i][0]>end){  //(starting one can always satisfy condition.)
                result = (2*result)%MOD;
            }
            end=Math.max(end,ranges[i][1]);
        }
        return result;
    }
}