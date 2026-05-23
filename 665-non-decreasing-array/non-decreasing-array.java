class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0, prevMax = Integer.MIN_VALUE,n=nums.length;
        for(int i=0;i<=n-2;i++){
            if(nums[i]>nums[i+1]){
                if(count==1) return false;
                count++;
                if(i<1||nums[i-1]<=nums[i+1]){
                    nums[i]=nums[i+1];
                }else{
                    nums[i+1]=nums[i];
                }
            }
        }
        return true;
    }
}