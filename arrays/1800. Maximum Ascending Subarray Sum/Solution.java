class Solution {
    public int maxAscendingSum(int[] nums) {
        int temp  = nums[0];
        int res= temp;
        for(int i=1; i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                temp+=nums[i];
            }else{
                temp=nums[i];
            }
            res = Math.max(res,temp);
        }
        return res;
    }
}
