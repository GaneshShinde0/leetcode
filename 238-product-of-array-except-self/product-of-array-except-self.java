class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[0] = 1;
        for(int i=1;i<n;i++){
            product[i]=nums[i-1]*product[i-1];
        }
        // [1, 1, 2, 6]
        int suff = nums[n-1];
        for(int j=n-2;j>=0;j--){
            product[j] *= suff;
            suff = suff*nums[j];
        }
        return product;
    }
}