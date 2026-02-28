class Solution {
    private static final int MOD = 1_000_000_007;
    public int getSum(int[] nums) {
        int n = nums.length;
        long len =0, sum = 0, res = 0;
        for(int i = 0; i<n; i++){
            if(i>0 && Math.abs(nums[i]-nums[i-1])==1){
                len++;
                sum = (sum+len*nums[i])%MOD;  // old sum + addition of nums[i] into old sum times consecutive length.
                res = (res+sum)%MOD;
                if(i<n-1 && nums[i+1]-nums[i]==nums[i-1]-nums[i]){ // Change of direction;
                    sum = nums[i];
                    len = 1;
                }
            }else{
                sum = nums[i];
                len = 1;
                res = (res+sum)%MOD;
            }
        }
        return (int) res;
    }
}