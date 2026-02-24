class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakHelper(nums,0, nums.length-1);
    }

    private int findPeakHelper(int[] nums, int left, int right){
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
    private int findPeakHelperDoesNotWork(int[] nums, int left, int right){
        if(left == right) return left;
        while(left<right){
            int mid = (left+right)/2;
            if(left==right) return left;
            else if(nums[mid]<=nums[right]) left = mid+1;
            else if(nums[mid]<=nums[left]) right = mid-1; 
            else if(nums[mid]>nums[right] && nums[mid]>nums[left]){
                int a = findPeakHelper(nums,left,mid);
                int b = findPeakHelper(nums,mid+1,right);
                if(nums[a]>nums[b]) return a;
                else return b;
            }
        }
        return right;
    }
}
