class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max,nums[i]);
        }
        System.out.println(gcd(5,0));
        return gcd(min,max);
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}