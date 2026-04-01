class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, result = 0, n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int right = 0; right<n;right++){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            while(hm.get(nums[right])>k){
                hm.put(nums[left], hm.getOrDefault(nums[left],0)-1);
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}