class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0]>=n) return n;

        for(int i=1;i<=n;i++){
            // Following condition checks if number at index n-i greater than or equal to i,
            // It also makes sure that number at index n-i-1 is less than i;
            if(nums[n-i]>=i && nums[n-i-1]<i){
                return i;
            }
        }
        return -1;
    }
}