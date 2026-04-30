class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] prefixLower = new int[n];
        prefixLower[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixLower[i] = Math.min(nums[i],prefixLower[i-1]);
        }
        int suffixLower = nums[n-1];
        int sum = Integer.MAX_VALUE;
        for(int i=n-2;i>=1;i--){
            if(nums[i]>prefixLower[i] && suffixLower<nums[i]){
                sum = Math.min(sum, nums[i]+prefixLower[i]+suffixLower);
            }
            suffixLower = Math.min(suffixLower,nums[i]);
        }
        return sum==Integer.MAX_VALUE?-1:sum;
    }
}