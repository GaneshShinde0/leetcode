class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] arr = new int[10001];
        int temp = Integer.MAX_VALUE;
        int left=0,right=0;
        for(int i:nums){
            arr[i]++;
            if(i>target) return 1;
        }
        int sum=0,n=nums.length;
        while(right<n){
            sum+=nums[right];
            right++;
            while(sum>=target){
                temp = Math.min(temp,right-left);
                sum-=nums[left];
                left++;
            }
        }
        return temp==Integer.MAX_VALUE?0:temp;
    }
}
