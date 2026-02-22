class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for(int element:nums){
            sum += element;
            maxElement = Math.max(maxElement, element);
        }
        // Define the left and right boundary of binary search
        int left = maxElement, right = sum;
        int minimumLargestSplitSum = 0;
        while(left<=right){
            // Mid Value: max sum allowed
            int mid = left + (right-left)/2;
            // Find the minimum splits. If SplitsRequired is less than or equal to M, move towards left i.e. smaller values
            if(minimumSubarraysRequired(nums, mid)<=k){
                right  = mid-1; 
                minimumLargestSplitSum = mid;
            }else{
                left = mid+1;
            }
        }
        return minimumLargestSplitSum;
    }

    private int minimumSubarraysRequired(int[] nums, int maxSumAllowed){
        int currentSum = 0, splitsRequired = 0;
        for(int element:nums){
            if(currentSum+element<=maxSumAllowed){
                currentSum  += element;
            }else{
                currentSum = element;
                splitsRequired++;
            }
        }
        return splitsRequired+1;
    }
}