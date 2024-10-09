class RotateArray {

    // Approach 1: Using Extra Array
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        
        // Copy rotated array back to nums
        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }
    }

    // Approach 2: Reverse Method (In-Place, Space O(1))
    public void rotateUsingReverseMethod(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k > n
        
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Approach 3: Cyclic Replacements (In-Place, Space O(1))
    public void rotateUsingCyclicReplacements(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k > n
        int count = 0;  // Tracks the number of elements rotated
        
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // Approach 4: Brute Force (In-Place, Space O(1))
    public void rotateUsingBruteForce(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k > n

        for (int i = 0; i < k; i++) {
            rotateOneStep(nums);
        }
    }

    private void rotateOneStep(int[] nums) {
        int n = nums.length;
        int last = nums[n - 1];
        
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        
        nums[0] = last;
    }

    // // Main method to test all the approaches
    // public static void main(String[] args) {
    //     RotateArray ra = new RotateArray();

    //     int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
    //     int k1 = 3;
    //     ra.rotateUsingExtraArray(nums1.clone(), k1);  // Test Approach 1
    //     ra.rotateUsingReverseMethod(nums1.clone(), k1);  // Test Approach 2
    //     ra.rotateUsingCyclicReplacements(nums1.clone(), k1);  // Test Approach 3
    //     ra.rotateUsingBruteForce(nums1.clone(), k1);  // Test Approach 4

    //     int[] nums2 = {-1, -100, 3, 99};
    //     int k2 = 2;
    //     ra.rotateUsingExtraArray(nums2.clone(), k2);  // Test Approach 1
    //     ra.rotateUsingReverseMethod(nums2.clone(), k2);  // Test Approach 2
    //     ra.rotateUsingCyclicReplacements(nums2.clone(), k2);  // Test Approach 3
    //     ra.rotateUsingBruteForce(nums2.clone(), k2);  // Test Approach 4
    // }
}
