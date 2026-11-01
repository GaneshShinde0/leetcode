class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0], res = 0;
        for(int num:nums) min = Math.min(num, min);
        for(int num:nums) res += num-min;
        return res;
    }
}