class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long res =1, alternating = 1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                alternating=1;
            }else{
                alternating+=1;
            }
            res += alternating;
        }
        return res;
    }
}