class Solution {

    public int longestRepeatingSubstring(String s) {
        int length = s.length();
        String[] suffixes = new String[length];

        // Create suffix array
        for (int i = 0; i < length; i++) {
            suffixes[i] = s.substring(i);
        }
        // Sort the suffix array using MSD Radix Sort
        msdRadixSort(suffixes);

        int maxLength = 0;
        // Find the longest common prefix between consecutive sorted suffixes
        for (int i = 1; i < length; i++) {
            int j = 0;
            while (
                j < Math.min(suffixes[i].length(), suffixes[i - 1].length()) &&
                suffixes[i].charAt(j) == suffixes[i - 1].charAt(j)
            ) {
                j++;
            }
            maxLength = Math.max(maxLength, j);
        }
        return maxLength;
    }

    // Main method to perform MSD Radix Sort
    private void msdRadixSort(String[] input) {
        sort(input, 0, input.length - 1, 0, new String[input.length]);
    }

    // Helper method for sorting
    private void sort(String[] input, int lo, int hi, int depth, String[] aux) {
        if (lo >= hi) return;

        int[] count = new int[28];
        for (int i = lo; i <= hi; i++) {
            count[charAt(input[i], depth) + 1]++;
        }
        for (int i = 1; i < 28; i++) {
            count[i] += count[i - 1];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(input[i], depth)]++] = input[i];
        }
        for (int i = lo; i <= hi; i++) {
            input[i] = aux[i - lo];
        }
        for (int i = 0; i < 27; i++) {
            sort(input, lo + count[i], lo + count[i + 1] - 1, depth + 1, aux);
        }
    }

    // Returns the character value or 0 if index exceeds string length
    private int charAt(String s, int index) {
        if (index >= s.length()) return 0;
        return s.charAt(index) - 'a' + 1;
    }
}