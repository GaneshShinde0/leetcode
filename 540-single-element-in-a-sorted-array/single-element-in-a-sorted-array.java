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
}