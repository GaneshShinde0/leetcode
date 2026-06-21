class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num:nums) total += num;
        int n = nums.length, maxI = -1, left = 0, curr = 0;
        for(int right = 0;right<n;right++){
            curr += nums[right];
            while(curr>total-x && left<=right){
                curr -= nums[left];
                left++;
            }
            if(curr == total-x){
                maxI = Math.max(maxI, right-left+1);
            }
        }
        return maxI !=-1 ?n-maxI : -1;
    }
}