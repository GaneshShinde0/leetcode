class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        return hm.getOrDefault(target,0)>(nums.length/2);
    }
}