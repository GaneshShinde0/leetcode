class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            minRight[i] = Math.min(nums[i],minRight[i+1]);
        }
        int maxLeft = nums[0];
        for(int i=1;i<n;i++){
            if(maxLeft<=minRight[i]) return i;
            maxLeft = Math.max(maxLeft,nums[i]);
        }
        return n-1;
    }
}