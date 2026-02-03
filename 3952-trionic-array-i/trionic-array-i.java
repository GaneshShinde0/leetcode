class Solution {
    public boolean isTrionic(int[] nums) {
        int  p =0, q=0, n=nums.length;
        for(int i= 1;i<n-1;i++){
            if(nums[i-1]==nums[i]) return false;
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
                if(p!=0 || q!=0) return false;
                p = i;
            }
            if(nums[i-1]>nums[i] && nums[i]<nums[i+1]){
                if(p==0||q!=0){ // If starting is satisfied and there is no existing q
                    return false;
                }
                q = i;
            }
        }
        if(nums[n-1]==nums[n-2]) return false;
        return q>0;
    }
}