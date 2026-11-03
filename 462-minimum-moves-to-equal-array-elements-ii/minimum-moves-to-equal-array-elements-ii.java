class Solution {
    // We just have to make sure all elements are same; we dont have to worry
    // Whether they are same or different.
    public int minMoves2(int[] nums) {
        // if(nums.length==1) return 0;
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        // if(nums.length%2==1){
        //     median = (nums[nums.length/2]+nums[(nums.length+1)/2])/2;
        // }
        int res = 0;
        for(int i:nums){
            res+=Math.abs(i-median);
        }
        return res;
    }
}