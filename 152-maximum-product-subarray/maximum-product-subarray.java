/*
Input: nums = [2,3,-2,-4]

58

*/

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            int temp = max;
            max = Math.max(max*num,Math.max(min*num, num));
            min = Math.min(min*num, Math.min(temp*num, num));
            res = Math.max(max, res);
        }
        return res;
    }
}