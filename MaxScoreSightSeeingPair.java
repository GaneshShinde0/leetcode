class MaxScoreSightSeeingPair {

    // Brute-force approach using nested for loops
    public int maxScoreSightseeingPairNestedForLoop(int[] values) {
        // Initialize max to store the maximum score found, start with the first value in the array
        int max = values[0];
        int len = values.length;
        
        // Initialize score to store the result of the maximum pair score
        int score = 0;

        // Outer loop iterates over each element in the array except the last
        for (int i = 0; i < len - 1; i++) {
            // Inner loop iterates over the elements after i
            for (int j = i + 1; j < len; j++) {
                // Calculate the score of the pair (i, j) and update the max score
                score = Math.max(score, values[i] + values[j] + i - j);
            }
        }

        // Return the maximum score found after all iterations
        return score;
    }

    // Optimized approach using a greedy strategy
    public int maxScoreSightseeingPair(int[] values) {
        // Initialize i to track the best starting point
        int i = 0;
        
        // Initialize max to store the maximum score found, start with the first value
        int max = values[i] + i;

        // Loop through the array starting from the second element
        for (int j = 1; j < values.length; j++) {
            // Calculate the score of the current pair (i, j)
            int curr = values[i] + values[j] + i - j;
            
            // If the current score is greater than the previous max, update max
            if (curr > max) {
                max = curr;
            }

            // Update i if a better starting point is found at j
            if (values[i] + i < values[j] + j) {
                i = j;
            }
        }

        // Return the maximum score found
        return max;
    }

    // Main method to run test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Expected output is 11
        int[] values1 = {8, 1, 5, 2, 6};
        System.out.println("Test Case 1:");
        System.out.println("Brute-force result: " + solution.maxScoreSightseeingPairNestedForLoop(values1)); // Output: 11
        System.out.println("Optimized result: " + solution.maxScoreSightseeingPair(values1));                // Output: 11

        // Test case 2: Expected output is 7
        int[] values2 = {1, 3, 5};
        System.out.println("\nTest Case 2:");
        System.out.println("Brute-force result: " + solution.maxScoreSightseeingPairNestedForLoop(values2)); // Output: 7
        System.out.println("Optimized result: " + solution.maxScoreSightseeingPair(values2));                // Output: 7

        // Test case 3: Expected output is 16
        int[] values3 = {10, 4, 2, 9, 3};
        System.out.println("\nTest Case 3:");
        System.out.println("Brute-force result: " + solution.maxScoreSightseeingPairNestedForLoop(values3)); // Output: 16
        System.out.println("Optimized result: " + solution.maxScoreSightseeingPair(values3));                // Output: 16

        // Test case 4: Expected output is 3
        int[] values4 = {2, 2, 2};
        System.out.println("\nTest Case 4:");
        System.out.println("Brute-force result: " + solution.maxScoreSightseeingPairNestedForLoop(values4)); // Output: 3
        System.out.println("Optimized result: " + solution.maxScoreSightseeingPair(values4));                // Output: 3

        // Test case 5: Expected output is 7
        int[] values5 = {1, 2, 3, 4, 5};
        System.out.println("\nTest Case 5:");
        System.out.println("Brute-force result: " + solution.maxScoreSightseeingPairNestedForLoop(values5)); // Output: 7
        System.out.println("Optimized result: " + solution.maxScoreSightseeingPair(values5));                // Output: 7
    }
}
