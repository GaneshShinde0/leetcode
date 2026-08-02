import java.util.Arrays;

class Solution {
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        
        // Step 1: Calculate all prefix sums
        long current = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                current += a; // Odd element contributes 'a'
            } else {
                current -= b; // Even element contributes '-b'
            }
            pre[i + 1] = current;
        }
        
        // Step 2: Coordinate Compression
        // We sort the prefix sums and remove duplicates so we can map them to 1-based ranks
        long[] sortedPre = pre.clone();
        Arrays.sort(sortedPre);
        
        int uniqueCount = 1;
        for (int i = 1; i < sortedPre.length; i++) {
            if (sortedPre[i] != sortedPre[i - 1]) {
                sortedPre[uniqueCount++] = sortedPre[i];
            }
        }
        
        // Step 3: Fenwick Tree (Binary Indexed Tree)
        long result = 0;
        int[] bit = new int[uniqueCount + 1];
        
        for (int i = 0; i <= n; i++) {
            // Find the 1-based rank of the current prefix sum
            int rank = binarySearch(sortedPre, uniqueCount, pre[i]);
            
            // Count how many previous prefix sums are <= pre[i]
            result += query(bit, rank);
            
            // Add the current prefix sum to the Fenwick tree
            update(bit, rank, 1);
        }
        
        return result;
    }
    
    // Helper: Binary search to find the 1-based rank
    private int binarySearch(long[] arr, int len, long target) {
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid + 1;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    // Helper: Add delta to the Fenwick Tree
    private void update(int[] bit, int i, int delta) {
        for (; i < bit.length; i += i & -i) {
            bit[i] += delta;
        }
    }
    
    // Helper: Query the prefix sum in the Fenwick Tree
    private int query(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) {
            sum += bit[i];
        }
        return sum;
    }
}