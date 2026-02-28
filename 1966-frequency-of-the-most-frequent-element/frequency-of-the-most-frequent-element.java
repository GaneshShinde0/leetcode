class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); // We want to make most elements equal, sorting will help with that
        int left = 0, ans = 0; // left pointer, best answer so far, sum of elements in our window
        long currSum = 0;
        for(int right = 0; right<nums.length; right++){
            long target = nums[right]; // considering long as multiplication might become 10^5*10^5 = 10^10 => outside 2^32 => 2,147,483,647
            currSum+=target;
            // previous window * target - current sum is>k 
            // i.e. consider array as 3 6 7 12 19 22 44 150
            // consider right is 3, so target will become 12
            // currentSum = 28, (target = 12) (target*4=48)
            // If our k is greater than (48-28 ) i.e. 20 then we can take window otherwise we will shrink the window.
            while((right-left+1)*target-currSum>k){ 
                currSum-=nums[left];
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}

