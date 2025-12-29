class Solution {
    public int minimumSplits(int[] nums) {
        int res = 1;
        int curr = nums[0];
        for(int i=1;i<nums.length;i++){
            int gcd = gcd(curr,nums[i]);
            if(gcd==1){
                res++;
                // Basically our current number should be in new window.
                gcd = nums[i]; 
                // if(i<nums.length-1) gcd = nums[i+1];// This does not work
            }
            curr = gcd;
        }
        return res;
    }

    private int gcd(int a, int b){
        return a%b==0?b:gcd(b%a,a);
    }
}