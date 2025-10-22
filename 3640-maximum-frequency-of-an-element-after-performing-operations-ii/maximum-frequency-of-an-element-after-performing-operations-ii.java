import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int op) {
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nums) freq.put(v, freq.getOrDefault(v, 0) + 1);

        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int left1 = lowerBound(nums, v - k);
            int right1 = upperBound(nums, v + k);
            int range1 = right1 - left1 - freq.get(v);  // elements in [v-k, v+k] excluding v itself

            // Option 1: use nearby elements within ±k
            int option1 = Math.min(range1, op) + freq.get(v);

            // Option 2: use elements in [v, v+2k]
            int right2 = upperBound(nums, v + 2 * k);
            int option2 = Math.min(right2 - i, op);

            res = Math.max(res, Math.max(option1, option2));
        }

        return res;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
