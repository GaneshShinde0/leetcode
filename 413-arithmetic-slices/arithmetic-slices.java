class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        var prev = 0;
        var slices = 0;
        
        for (var i = 2; i < nums.length; i++)
            slices += (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) 
                    ? ++prev 
                    : (prev = 0);
        
        return slices;
    }
}