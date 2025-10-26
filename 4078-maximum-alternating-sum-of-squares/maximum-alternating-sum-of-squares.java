class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int n=nums.length;
        long res = 0;
        for(int i=0;i<n/2;i++){
            res-=nums[i]*nums[i];
        }
        for(int i=n/2;i<n;i++){
            res+=nums[i]*nums[i];
        }
        return res;
    }
}