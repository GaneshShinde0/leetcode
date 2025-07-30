class Solution {
    public int longestSubarrayUsing2Loops(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>max) max = i;
        }
        int maxCount=0;
        int maxCountLocal=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]&&nums[i]==max){
                maxCountLocal++;
            }else{
                maxCount=Math.max(maxCountLocal, maxCount);
                maxCountLocal=0;
            }
        }
        return Math.max(maxCountLocal, maxCount)+1;
    }

    // Using Bitwise And
    public int longestSubarrayUsingAnd(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int longest = 0;
        int currentLength = 0;

        // Single loop to find both the max element and longest subarray
        for (int num : nums) {
            // Find the maximum element
            if (num > maxNum) {
                maxNum = num;
                currentLength = 1;  // Reset current length since this is the new max
                longest = 1;        // Update the longest subarray length
            } else if ((num & maxNum)==maxNum) {
                // Increase the current subarray length if it matches maxNum
                currentLength++;
                longest = Math.max(longest, currentLength);
            } else {
                // Reset current subarray length if it's not equal to maxNum
                currentLength = 0;
            }
        }
        return longest;
    }
    // SigleForLoop
    public int longestSubarray(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int longest = 0;
        int currentLength = 0;

        // Single loop to find both the max element and longest subarray
        for (int num : nums) {
            // Find the maximum element
            if (num > maxNum) {
                maxNum = num;
                currentLength = 1;  // Reset current length since this is the new max
                longest = 1;        // Update the longest subarray length
            } else if (num == maxNum) {
                // Increase the current subarray length if it matches maxNum
                currentLength++;
                longest = Math.max(longest, currentLength);
            } else {
                // Reset current subarray length if it's not equal to maxNum
                currentLength = 0;
            }
        }
        return longest;
    }    

}