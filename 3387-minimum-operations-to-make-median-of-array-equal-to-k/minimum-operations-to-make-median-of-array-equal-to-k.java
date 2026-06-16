class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        long res = 0;
        if(nums[mid]<k){
            for(int i=mid;i<nums.length;i++){
                if(nums[i]<k){
                    res+=k-nums[i];
                }else{
                    break;
                }
            }
        }
        if(nums[mid]>k){
            for(int i=mid;i>=0;i--){
                if(nums[i]>k){
                    res+=nums[i]-k;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}