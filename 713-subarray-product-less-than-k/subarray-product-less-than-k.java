class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int n  = nums.length;
        int res = 0;
        int left = 0, right = 0;
        if (k <= 1) return 0;
        while(right<n){
            prod*=nums[right];
            while(prod>=k){
                prod/=nums[left];
                left++;
            }
            res+=right-left+1;
            right++;
        }
        System.out.println("Left: "+left+", Right: "+right);
        return res;
    }
}