class Solution {
    public long gcdSum(int[] nums) {
        int currMax = nums[0], n = nums.length;
        int[] prefixGcd = new int[n];
        for(int i=0;i<n;i++){
            currMax = Math.max(currMax, nums[i]);
            prefixGcd[i] = gcd(currMax,nums[i]);
        }
        Arrays.sort(prefixGcd);

        long result = 0;
        for(int i=0;i<n/2;i++){
            result+=gcd(prefixGcd[i],prefixGcd[n-i-1]);
        }
        return result;
    }
    private  int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}