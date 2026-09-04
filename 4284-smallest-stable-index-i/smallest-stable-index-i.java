class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length, max = nums[0];
        int[] suffixMin = new int[n];
        suffixMin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMin[i] = Math.min(nums[i],suffixMin[i+1]);
        }
        for(int i=0;i<n;i++){
            if(max-suffixMin[i]<=k) return i;
            max = Math.max(max, nums[i]);
        }
        return -1;
    }
}