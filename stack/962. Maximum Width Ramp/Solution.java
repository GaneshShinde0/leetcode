class Solution {
    
    /**
     * Max Width Ramp using Sorting.
     * 
     * Approach: 
     * The idea is to sort the indices of the array based on their corresponding values in the input array `nums`. 
     * After sorting, we scan through the sorted indices to compute the maximum difference between indices that maintain 
     * the "ramp" condition, i.e., nums[i] <= nums[j] for i < j. Sorting the indices ensures that the ramp condition 
     * is preserved. We keep track of the smallest index encountered so far and compare it with the current index to 
     * find the maximum width.
     * 
     * Why it works: 
     * Sorting helps group elements such that the smaller elements (and their indices) appear first. This allows us 
     * to efficiently compute the maximum width by just checking how far the current index is from the minimum index 
     * encountered so far.
     * 
     * Time Complexity: O(n log n) - Sorting takes O(n log n) time, 
     * and iterating through indices to compute the maximum width takes O(n).
     * 
     * Space Complexity: O(n) - Additional space for the 'indices' array.
     */
    public int maxWidthRampUsingSorting(int[] nums) {
        int n = nums.length;
        // Initiating an array of wrapper class so that it will be easy to use comparator later.
        Integer[] indices = new Integer[n];

        // Initialize the array with indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on corresponding values in nums and ensure stability.
        Arrays.sort(indices, (i, j) -> {
            return nums[i] != nums[j] ? nums[i] - nums[j] : i - j; // Sort by values first, then by indices.
        });

        int minIndex = n; // Minimum index encountered so far.
        int maxWidth = 0;

        // Calculate maximum width of ramp.
        for (int i : indices) {
            maxWidth = Math.max(maxWidth, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }
        return maxWidth;
    }

    /**
     * Brute Force Approach.
     * 
     * Approach: 
     * This approach simply checks every pair of indices (i, j) where i < j to find the maximum width where nums[i] <= nums[j].
     * It uses two nested loops to iterate through all possible pairs and checks the ramp condition.
     * 
     * Why it works: 
     * This is the most straightforward approach, where we brute-force check all possible index pairs. It works because
     * we systematically test all conditions, but it is very inefficient.
     * 
     * Time Complexity: O(n^2) - Nested loops iterating over all pairs of indices.
     * 
     * Space Complexity: O(1) - Constant space used (no additional arrays).
     */
    public int maxWidthRampBF(int[] nums) {
        int res = 0;

        // Iterate through all pairs (i, j) and check if nums[i] <= nums[j]
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; i < j; j--) {
                if (nums[i] <= nums[j]) {
                    res = Math.max(j - i, res); // Update the result with the maximum width.
                }
            }
        }
        return res;
    }

    /**
     * Two Pointers Approach.
     * 
     * Approach: 
     * This approach creates an auxiliary array `rightMax` that stores the maximum values from the current index to the 
     * end of the array. Then, two pointers (left and right) traverse the array, adjusting based on the condition that 
     * nums[left] <= rightMax[right]. This allows us to compute the maximum width in a linear pass.
     * 
     * Why it works: 
     * By precomputing the maximum values from the right in the `rightMax` array, we can efficiently check if the condition 
     * nums[left] <= rightMax[right] holds. The two-pointer traversal ensures we can find the widest ramp in O(n) time.
     * 
     * Time Complexity: O(n) - Precomputing the rightMax array takes O(n), and traversing the array with two pointers 
     * also takes O(n).
     * 
     * Space Complexity: O(n) - Space used for the rightMax array.
     */
    public int maxWidthRampTwoPointer(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];

        // Fill rightMax array with maximum values from the right.
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        // Traverse the array using left and right pointers.
        while (right < n) {
            while (left < right && nums[left] > rightMax[right]) {
                left++; // Increment left pointer until nums[left] <= rightMax[right].
            }
            maxWidth = Math.max(maxWidth, right - left); // Update maximum width.
            right++; // Increment the right pointer.
        }
        return maxWidth;
    }

    /**
     * Monotonic Stack Approach.
     * 
     * Approach: 
     * The monotonic stack approach works by pushing indices onto a stack in a decreasing order of their values.
     * We then iterate backwards through the array to find valid ramp indices (i, j) where i < j and nums[i] <= nums[j].
     * The stack ensures that each index on the stack has a value that is greater than or equal to any subsequent values.
     * 
     * Why it works: 
     * By pushing indices in a decreasing order of values, the stack allows us to find valid ramps in a single backward
     * traversal of the array. Whenever we find nums[j] >= nums[stack.peek()], we pop the stack and compute the width.
     * 
     * Time Complexity: O(n) - One pass to build the stack and another pass to calculate the ramp.
     * 
     * Space Complexity: O(n) - Space used for the stack.
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> indicesStack = new Stack<>();

        // Fill the stack with indices in increasing order of their values.
        for (int i = 0; i < n; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i); // Only push indices with smaller values onto the stack.
            }
        }

        int maxWidth = 0;

        // Traverse the array from the end to start.
        for (int j = n - 1; j >= 0; j--) {
            // Compare values from the end with the top of the stack.
            while (!indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - indicesStack.peek()); // Update the max width.
                indicesStack.pop(); // Remove the top of the stack as we have found a valid ramp.
            }
        }
        return maxWidth;
    }
}
