class Solution {
    public long subsequenceSumOr(int[] nums) {
        long bits = 0, sum = 0;
        Arrays.sort(nums);
        for(int num:nums){
            sum += num;
            bits |= num;       // accumulate bits from the number itself
            bits |= sum;       // accumulate bits from the running prefix sum
        }
        return bits;
    }
}