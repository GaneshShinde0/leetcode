class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = 0, min = Integer.MAX_VALUE;
        for(int i:nums){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return k*(max-min);
    }
}