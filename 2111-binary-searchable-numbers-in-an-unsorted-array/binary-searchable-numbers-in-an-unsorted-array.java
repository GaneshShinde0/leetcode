class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int n= nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        maxLeft[0] = Integer.MIN_VALUE;
        minRight[n-1] = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            maxLeft[i] = Math.max(nums[i-1],maxLeft[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            minRight[i] = Math.min(nums[i+1], minRight[i+1]);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>maxLeft[i] && nums[i]<minRight[i]) res++;
        }
        return res;
    }
}