class Solution {
    public int largestInteger(int[] nums, int k) {
        int firstFreq = 0, lastFreq=0, n = nums.length;

        if(k==1){
            int[] freq = new int[51];
            for(int i:nums){
                freq[i]++;
            }
            for(int i=50;i>=0;i--){
                if(freq[i]==1) return i;
            }
            return -1;
        }
        if(n==k){
            int[] freq = new int[51];
            for(int i:nums){
                freq[i]=1;
            }
            for(int i=50;i>=0;i--){
                if(freq[i]==1) return i;
            }
            return -1;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==nums[0])firstFreq++;
            else if(nums[i]==nums[n-1])lastFreq++;
        }
        if(firstFreq==1 && lastFreq==1) return Math.max(nums[0],nums[n-1]);
        else if(firstFreq==1) return nums[0];
        else if (lastFreq==1) return nums[n-1];
        else return -1;
    }
}