class IsLeftSumEqualsRight {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate through the array and check for the middle index
        for (int i = 0; i < nums.length; i++) {
            // totalSum now represents the right sum for index i
            totalSum -= nums[i];
            if (leftSum == totalSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
