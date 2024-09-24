class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestPrefix = 0;

        HashSet<Integer> arr1Prefixes = new HashSet<Integer>(); // Set to store all prefixes from arr1
        // Step 1: Build all possible prefixes from arr1
        for (int val : arr1) {
            while (!arr1Prefixes.contains(val) && val > 0) {
                // Insert current value as a prefix
                arr1Prefixes.add(val);
                // Generate the next shorter prefix by removing the last digit
                val /= 10;
            }
        }
    
        // Step 2: Check each number in arr2 for the longest matching prefix
        for (int val : arr2) {
            while (!arr1Prefixes.contains(val) && val > 0) {
                // Reduce val by removing the last digit if not found in the prefix set
                val /= 10;
            }
            if (val > 0) {
                // Length of the matched prefix using log10 to determine the number of digits
                longestPrefix = Math.max(
                    longestPrefix,
                    (int) Math.log10(val) + 1
                );
            }
        }

        return longestPrefix;
    }
    public int getLongestCommonPrefix(String s, String inner){
        int len = Math.min(s.length(),inner.length());
        int i=0;
        while(i<len && s.charAt(i)==inner.charAt(i)){
            i++;
        }
        return i;
    }
}
