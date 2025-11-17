class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(temp>0) return false;
                temp = k;
            }else{
                temp--;
            }
        }
        return true;
    }
}