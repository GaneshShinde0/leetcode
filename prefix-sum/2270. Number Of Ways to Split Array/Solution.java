class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int i:nums){
            sum+=i;
        }
        long leftSum=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            leftSum+=nums[i];
            sum-=nums[i];
            if(leftSum>=sum) count++;
        }
        return count;
    }
}
