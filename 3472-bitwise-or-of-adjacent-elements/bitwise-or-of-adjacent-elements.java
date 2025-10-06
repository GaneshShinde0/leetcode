class Solution {
    public int[] orArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n-1];
        for(int i=0;i<n-1;i++){
            res[i]=nums[i]|nums[i+1];
        }
        return res;
    }
}