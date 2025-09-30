import java.math.BigInteger;
class Solution {
    public int triangularSumInitial(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                nums[j]=(nums[j+1]+nums[j])%10;
            }
            // System.out.println(Arrays.toString(nums));
        }
        return nums[0];
    }

    public int triangularSum(int[] nums) {
        int n = nums.length;
        BigInteger C = BigInteger.ONE;      // C(n-1,0)
        BigInteger res = BigInteger.ZERO;
        BigInteger MOD = BigInteger.TEN;

        for (int i = 0; i < n; i++) {
            res = res.add(C.multiply(BigInteger.valueOf(nums[i]))).mod(MOD);
            if (i < n - 1) {
                C = C.multiply(BigInteger.valueOf(n - 1 - i))
                     .divide(BigInteger.valueOf(i + 1));
            }
        }
        return res.intValue();
    }
}
