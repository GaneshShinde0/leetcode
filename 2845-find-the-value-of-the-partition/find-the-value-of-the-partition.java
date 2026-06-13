class Solution {
    public int findValueOfPartition(int[] nums) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            res = Math.min(res, nums[i]-nums[i-1]);
        }
        return res;
    }
}