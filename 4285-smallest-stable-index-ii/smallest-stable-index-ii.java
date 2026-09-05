class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxFromFront = new int[n];
        maxFromFront[0] = nums[0];
        for(int i=1;i<n;i++){
            maxFromFront[i] = Math.max(maxFromFront[i-1],nums[i]);
        }
        int minFromEnd = nums[n-1];
        int result = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            minFromEnd = Math.min(minFromEnd, nums[i]);
            maxFromFront[i] = maxFromFront[i]-minFromEnd;
            if(maxFromFront[i]<=k){
                result = i;
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}