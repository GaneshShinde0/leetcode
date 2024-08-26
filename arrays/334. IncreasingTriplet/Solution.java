class Solution {
    public boolean increasingTripletForAdjacentDigits(int[] nums) {
        for(int i=2;i<nums.length;i++){
            if (nums[i-2]<nums[i-1] && nums[i-1]<nums[i])return true;
        }
        return false;
    }

    public boolean increasingTriplet3ms(int[] nums) {
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min1) min1 = nums[i];
            if(nums[i]>min1 && nums[i]<min2)  min2 = nums[i];
            if(nums[i]>min1 && nums[i]>min2) return true;
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=min1) {
                min1 = nums[i];
            }else if(nums[i]<=min2){
                min2 = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
