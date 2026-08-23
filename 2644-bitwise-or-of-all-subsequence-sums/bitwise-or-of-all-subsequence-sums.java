class Solution {
    public long subsequenceSumOr(int[] nums) {
        long bits = 0, sum = 0;
        for(int num:nums){
            sum += num;
            bits |=num;// Accumulate bits from number.
            bits |=sum;// Accumulate bits from Sum.
        }
        return bits;
    }
}