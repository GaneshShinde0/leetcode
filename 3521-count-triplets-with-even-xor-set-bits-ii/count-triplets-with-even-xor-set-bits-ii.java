class Solution {
    public long tripletCount(int[] a, int[] b, int[] c) {
        long[] aBits = countEvenOddBits(a);
        long[] bBits = countEvenOddBits(b);
        long[] cBits = countEvenOddBits(c);
        long ans = 0;
        ans += aBits[0]*bBits[0]*cBits[0]; // Evens.
        ans += (aBits[1]*bBits[1]*cBits[0])+(aBits[1]*bBits[0]*cBits[1])+(aBits[0]*bBits[1]*cBits[1]);
        return ans;
    }

    private long[] countEvenOddBits(int[] nums){
        long[] bits = new long[2];
        for(int i=0;i<nums.length;i++){
            int temp = Integer.bitCount(nums[i]);
            bits[temp%2]++;
        }
        return bits;
    }
}