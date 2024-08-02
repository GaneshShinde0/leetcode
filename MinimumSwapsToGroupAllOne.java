class MinimumSwapsToGroupAllOne {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            totalOnes += nums[i];
        }
        
        int currentOnesInWindow = 0;
        int minSwaps = nums.length;
        
        for (int j = 0; j < nums.length; j++) {
            currentOnesInWindow += nums[j];
            if (j >= totalOnes) {
                currentOnesInWindow -= nums[j - totalOnes];
            }
            if (j >= totalOnes - 1) {
                minSwaps = Math.min(minSwaps, totalOnes - currentOnesInWindow);
            }
        }
        
        for (int i = 0; i <= totalOnes - 2; i++) {
            // Considering the circular nature of the array
            currentOnesInWindow = currentOnesInWindow + nums[i] - nums[nums.length - totalOnes + i];
            minSwaps = Math.min(minSwaps, totalOnes - currentOnesInWindow);
        }
        
        return minSwaps;
    }

}
