class Solution {
    public int longestSubarray(int[] nums, int k) {
        int res = 0, left = 0, right = 0, n = nums.length, windowSize = 0;
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for (; right < n; right++) {
            if (hm1.containsKey(nums[right]))
                hm2.put(nums[right], hm2.getOrDefault(nums[right], 0) + 1);
            hm1.put(nums[right], hm1.getOrDefault(nums[right], 0) + 1);
            while (left < right && hm2.size() > k) {
                hm1.put(nums[left], hm1.getOrDefault(nums[left], 0) - 1);
                if (hm1.get(nums[left]) == 0)
                    hm1.remove(nums[left]);
                hm2.put(nums[left], hm2.getOrDefault(nums[left], 0) - 1);
                if (hm2.get(nums[left]) <= 0)
                    hm2.remove(nums[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}