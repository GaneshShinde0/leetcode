class Solution {
    public long countSubarrays(int[] nums) {
        int n = nums.length;
        long res  = n;
        long curr = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                curr++;
            }else{
                res += ((curr-1)*(curr)/2);
                curr = 1;
            }
        }
        res += (curr*(curr-1)/2);
        return res;
    }
}