class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;  // Initialize count to keep track of consecutive pattern matches

        // Iterate through the array with two pointers, i and j
        // i starts at the beginning, j starts m elements ahead
        for (int i = 0, j = i + m; j < arr.length; i++, j++) {

            // If the elements at i and j do not match
            if (arr[i] != arr[j]) {
                count = 0;  // Reset count since the pattern is broken
            } 
            // If the elements at i and j match
            else {
                count++;  // Increment count as part of the pattern matches

                // Check if the pattern has been repeated k times
                if (count == (k - 1) * m) {
                    return true;  // If so, return true
                }
            }
        }

        // If the loop finishes without finding the pattern repeated k times, return false
        return false;
    }
}
