/*

Input: nums = [4,3,2,6]
PrefixSum:
[0,4,7,9]
SuffixSum:
[11,8,6,0]


F[0]=25
f[i]=f[i-1]-(n-1)*nums[n-i]+prefixSum[n-i]+SuffixSum[n-i];

F[1]=25-3*6+7=>25-18+9+0=>16
F[2]=16-3*2+7+6=>23
F[3]=23-3*3+4+8=>26
*/
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+nums[i+1];
        }
        int[] f = new int[n];
        for(int i=0;i<n;i++){
            f[0]+=(i*nums[i]);
        }
        int res = f[0];
        for(int i=1;i<n;i++){
            f[i]=f[i-1]-(n-1)*nums[n-i]+prefixSum[n-i]+suffixSum[n-i];
            res = Math.max(res, f[i]);
        }
        return res;
    }
}