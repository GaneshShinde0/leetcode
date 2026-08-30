class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0, maxIdx=0, n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;
            }else if(nums[i]<nums[minIdx]){
                minIdx = i;
            }
        }

        int fromFrontAndBack = n-Math.abs(minIdx-maxIdx)+1;
        int fromFront = Math.max(minIdx, maxIdx)+1;
        int fromBack = n-Math.min(minIdx, maxIdx);
        return Math.min(Math.min(fromFront,fromBack), fromFrontAndBack);
    }
}