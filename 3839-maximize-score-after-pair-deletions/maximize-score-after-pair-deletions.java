class Solution {
    public int maxScore(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        if (nums.length % 2 != 0) {
            return totalSum - Arrays.stream(nums).min().getAsInt();}
        else {
            int minPairSum = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 1; i++) {
                minPairSum = Math.min(minPairSum, nums[i] + nums[i + 1]); }
            return totalSum - minPairSum; }
    }
}