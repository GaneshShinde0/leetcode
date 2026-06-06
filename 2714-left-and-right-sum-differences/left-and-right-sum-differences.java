class Solution {
    public int[] leftRightDifference(int[] nums) {
        int prefSum = 0, n = nums.length, suffSum = 0;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=prefSum;
            prefSum+=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            res[i]=Math.abs(res[i]-suffSum);
            suffSum+=nums[i];
        }
        return res;
    }
}