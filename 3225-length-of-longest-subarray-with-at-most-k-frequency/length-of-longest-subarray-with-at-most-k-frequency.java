class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, result = 0, n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int right = 0; right < n; right++) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while (hm.get(nums[right]) > k) {
                hm.put(nums[left], hm.getOrDefault(nums[left], 0) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int maxSubarrayLengthCoOrdinateCompression(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Coordinate Compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        // Use binary search to "compress" each value to its rank/index
        int[] compressed = new int[n];
        for (int i = 0; i < n; i++) {
            compressed[i] = Arrays.binarySearch(sorted, nums[i]);
        }

        // 2. Sliding Window with primitive array
        int[] freq = new int[n]; // At most n unique elements
        int left = 0, result = 0;
        
        for (int right = 0; right < n; right++) {
            int val = compressed[right];
            freq[val]++;
            
            // Shrink window if frequency exceeds k
            while (freq[val] > k) {
                freq[compressed[left]]--;
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}