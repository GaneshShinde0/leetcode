class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int j=0;
        int i=0;
        for(;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
                
            }
            if(nums[i]!=0){
                res[j]=nums[i];
                j++;
            }
        }
        if(nums[i]!=0){
            res[j]=nums[i];
        }
        return res;
    }
}
