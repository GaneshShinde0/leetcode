class Solution {
    public boolean isMajorityElementInitial(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        return hm.getOrDefault(target,0)>(nums.length/2);
    }
    // As nums is sorted;
    public boolean isMajorityElement(int[] nums, int target) {
        if(nums[nums.length / 2] != target) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        right = nums.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int end = nums[right] == target ? right : left;
        return end - start + 1 > nums.length / 2;
    }
}