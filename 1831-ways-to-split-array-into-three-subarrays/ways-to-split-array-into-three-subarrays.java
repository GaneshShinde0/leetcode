class Solution {
    private final int MOD = 1_000_000_007;
    public int waysToSplit(int[] nums) {
        int size = nums.length, res = 0;
        // Calculate Prefix Sum.
        for(int i=1;i<size;i++){
            nums[i] += nums[i-1];
        }

        for(int i=0,j=0,k=0;i<size-2;i++){
            while(j<=i || (j<size-1 && nums[j]<nums[i]*2)){
                j++;
            }
            while(k<j || (k<size-1 && nums[k]-nums[i] <= nums[size-1]-nums[k])){
                k++;
            }
            res = (res+k-j)%MOD;
        }
        return res;
    }
}