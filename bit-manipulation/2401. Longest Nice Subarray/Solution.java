class Solution {
    public int longestNiceSubarrayBinarySearch(int[] nums) {
        int left = 0, right = nums.length;
        int result = 1;
        while(left<=right){
            int length = left+(right-left)/2;
            if(canFormNiceSubarray(length,nums)){
                result = length;
                left = length+1;
            }else{
                right = length-1;
            }
        }
        return result;
    }

    private boolean canFormNiceSubarray(int length, int[] nums){
        if(length<=1) return true;
        for(int start = 0; start<=nums.length-length;start++){
            int bitMask = 0;
            boolean isNice = true;
            for(int i=start;i<start+length;i++){
                if((bitMask&nums[i])!=0){
                    isNice = false;
                    break;
                }
                bitMask|=nums[i];
            }
            if(isNice) return true;
        }
        return false;
    }

    public int longestNiceSubarray(int[] nums){
        int usedBits = 0;
        int start = 0;
        int res = 0;
        for(int end = 0;end<nums.length;end++){
            while((usedBits&nums[end])!=0){
                usedBits ^= nums[start];
                start++;
            }

            
            //Add current number to the window
            usedBits |= nums[end];
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
