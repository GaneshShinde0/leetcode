class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max,nums[i]);
        }
        return gcd(max,min);
    }
    private int gcd(int a, int b){
        // if(a<b) return gcd(b,a);
        return a%b==0?b:gcd(b,a%b);
    }
}