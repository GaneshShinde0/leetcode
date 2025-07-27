class Solution {
    public int countHillValley(int[] nums) {
        int hill=0,left=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if ((nums[i]>left&&nums[i]>nums[i+1])||(nums[i]<left&&nums[i]<nums[i+1])){
                 hill++; 
                 left = nums[i];
            }
        }
        return hill;
    }
}