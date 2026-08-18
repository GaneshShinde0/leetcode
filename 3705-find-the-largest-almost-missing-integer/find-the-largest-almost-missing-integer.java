class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for(int num:nums){
            freq[num]++;
        }
        if(k==1){
            int max = -1;
            for(int num:nums){
                if(freq[num]==1) max = Math.max(max,num);
            }
            return max;
        }
        if(k==n){
            int max = -1;
            for(int num:nums) max = Math.max(num,max);
            return max;
        }
        if(k==n || (freq[nums[0]]==1 && freq[nums[n-1]]==1)) return Math.max(nums[0],nums[n-1]);
        else if(freq[nums[0]]==1) return nums[0];
        else if(freq[nums[n-1]]==1) return nums[n-1];
        return -1;
    }
}