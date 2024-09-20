class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length<=1) return 0;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        // As we need k elements we will take i+k
        // But we are also starting from 0 so it will be i+k-1
        for(int i=0; i+k-1<nums.length;i++){
            min=Math.min(min,Math.abs(nums[i]-nums[i+k-1]));
        }
        return min;
    }
}
