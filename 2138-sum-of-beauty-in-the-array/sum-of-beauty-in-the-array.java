class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length, maxLeft = 0;
        int[] minRight = new int[n];
        Arrays.fill(minRight,Integer.MAX_VALUE);
        int beautySum = 0;
        for(int i=1;i<n;i++){
            minRight[n-i-1] = Math.min(nums[n-i],minRight[n-i]);
        }
        for(int i=1;i<n-1;i++){
            maxLeft = Math.max(nums[i-1],maxLeft);
            if(maxLeft<nums[i] && nums[i]<minRight[i]) beautySum+=2;
            else if(nums[i-1]<nums[i] && nums[i]<nums[i+1]) beautySum+=1;
        }
        return beautySum;
    }
}