class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long res =1, consecutive = 1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                consecutive=1;
            }else{
                consecutive+=1;
            }
            res += consecutive;
        }
        return res;
    }
}