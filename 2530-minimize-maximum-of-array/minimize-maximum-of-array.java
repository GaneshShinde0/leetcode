/*
Input: nums = [3,7,1,6]
Input: nums = [4,6,1,6]
Input: nums = [5,5,1,6]
Input: nums = [5,5,2,5]

*/
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long currSum =0;
        long res = 0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            res = Math.max((int) Math.ceil(currSum/(i+1.0)),res);
        }
        return (int) res;
    }
}