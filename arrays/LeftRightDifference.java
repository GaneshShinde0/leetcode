class LeftRightDifference {
    public int[] leftRightDifference2ms1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int leftSum = 0, rightSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            rightSum += num;
        }

        // Loop to calculate the left sum and the difference between left and right sum
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];  // Decrement the current element from the right sum
            answer[i] = Math.abs(leftSum - rightSum);  // Calculate the absolute difference
            leftSum += nums[i];  // Add the current element to the left sum
        }

        return answer;
    }

    public int[] leftRightDifference2ms(int[] nums) {
        int[] answer = new int[nums.length];
        int leftSum=0,rightSum=0;
        for (int i=1;i<nums.length;i++){
            rightSum+=nums[i];
        }
        answer[0]= rightSum;
        for (int i=1;i<nums.length;i++){
            leftSum+=nums[i-1];
            rightSum-=nums[i];
            answer[i]= Math.abs(rightSum-leftSum);
        }
        return answer;
    }

    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        getDifference(nums, ans, 0, 0);
        return ans;
    }

    public int getDifference(int[] A, int[] res, int i, int leftSum){
        if(i == A.length){
            return 0;
        }

        int rightSum = getDifference(A, res, i + 1, leftSum + A[i]);
        res[i] = Math.abs(leftSum - rightSum);
        return rightSum + A[i];
    }
}
