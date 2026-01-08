class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low =0, high = nums.length-1;
        if(high==0) return nums[0];
        while(low<high){
            int mid = (low+high)/2;
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    high = mid-2;
                }else if(nums[mid]==nums[mid+1]){
                    low = mid+2;
                }else{
                    return nums[mid];
                }
            }else{
                if(nums[mid]==nums[mid+1]){
                    high = mid-1;
                }else if(nums[mid]==nums[mid-1]){
                    low = mid+1;
                }else{
                    return nums[mid];
                }        
            }
        }
        return nums[low];
    }

     public int singleNonDuplicateAlternate(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            
            // TRICK: Ensure mid is even. 
            // If mid is odd, decrement to make it even.
            if (mid % 2 == 1) {
                mid--; 
            }
            
            // Now we check if the pair (even, odd) matches
            if (nums[mid] == nums[mid + 1]) {
                // Pair is valid, so single element is to the RIGHT
                // We can skip this pair completely (mid and mid+1)
                low = mid + 2;
            } else {
                // Pair is broken (or we are at the single element)
                // The single element is either at 'mid' or to the LEFT
                high = mid;
            }
        }
        return nums[low];
    }
}