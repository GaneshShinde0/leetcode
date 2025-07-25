class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int or = nums[i];
            int j=i+1;
            for(;j<n;j++){
                if(or>=k) res = Math.min(res,j-i);
                or |=nums[j];
            }
            if(or>=k) res = Math.min(res,j-i);

        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}